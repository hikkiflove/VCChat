package com.vc.chat.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lqr.adapter.LQRAdapterForRecyclerView;
import com.lqr.adapter.LQRViewHolderForRecyclerView;
import com.lqr.recyclerview.LQRRecyclerView;
import com.vc.chat.R;
import com.vc.chat.db.DBManager;
import com.vc.chat.db.model.GroupMember;
import com.vc.chat.model.cache.UserCache;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.base.BasePresenter;
import com.vc.chat.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.rong.imlib.model.UserInfo;

/**
 * @author Hikki
 *         移出群成员界面
 */

public class RemoveGroupMemberActivity extends BaseActivity {

    @BindView(R.id.btnToolbarSend)
    Button mBtnToolbarSend;
    @BindView(R.id.rvMember)
    LQRRecyclerView mRvMember;
    private String mGroupId;
    private List<GroupMember> mData = new ArrayList<>();
    private List<GroupMember> mSelectedData = new ArrayList<>();
    private LQRAdapterForRecyclerView<GroupMember> mAdapter;

    @Override
    public void init() {
        mGroupId = getIntent().getStringExtra("sessionId");
    }

    @Override
    public void initView() {
        if (TextUtils.isEmpty(mGroupId)) {
            finish();
            return;
        }

        mBtnToolbarSend.setText(UIUtils.getString(R.string.delete));
        mBtnToolbarSend.setVisibility(View.VISIBLE);
        mBtnToolbarSend.setBackgroundResource(R.drawable.shape_btn_delete);
        mBtnToolbarSend.setEnabled(false);
    }

    @Override
    public void initData() {
        List<GroupMember> groupMembers = DBManager.getInstance().getGroupMembers(mGroupId);
        if (groupMembers != null && groupMembers.size() > 0) {
            for (int i = 0; i < groupMembers.size(); i++) {
                GroupMember groupMember = groupMembers.get(i);
                if (groupMember.getUserId().equals(UserCache.getId())) {
                    groupMembers.remove(i);
                    break;
                }
            }
            mData.clear();
            mData.addAll(groupMembers);
        }
        setAdapter();
    }

    @Override
    public void initListener() {
        mBtnToolbarSend.setOnClickListener(v -> {
            ArrayList<String> selectedIds = new ArrayList<>(mSelectedData.size());
            for (int i = 0; i < mSelectedData.size(); i++) {
                GroupMember groupMember = mSelectedData.get(i);
                selectedIds.add(groupMember.getUserId());
            }
            Intent data = new Intent();
            data.putStringArrayListExtra("selectedIds", selectedIds);
            setResult(Activity.RESULT_OK, data);
            finish();
        });
    }

    private void setAdapter() {
        if (mAdapter == null) {
            mAdapter = new LQRAdapterForRecyclerView<GroupMember>(this, mData, R.layout.item_contact) {
                @Override
                public void convert(LQRViewHolderForRecyclerView helper, GroupMember item, int position) {
                    helper.setText(R.id.tvName, item.getName()).setViewVisibility(R.id.cb, View.VISIBLE);
                    ImageView ivHeader = helper.getView(R.id.ivHeader);
                    Glide.with(RemoveGroupMemberActivity.this).load(item.getPortraitUri()).centerCrop().into(ivHeader);

                    CheckBox cb = helper.getView(R.id.cb);
                    cb.setClickable(true);
                    cb.setChecked(mSelectedData.contains(item) ? true : false);
                    cb.setOnClickListener(v -> {
                        if (cb.isChecked()) {
                            mSelectedData.add(item);
                        } else {
                            mSelectedData.remove(item);
                        }
                        if (mSelectedData.size() > 0) {
                            mBtnToolbarSend.setEnabled(true);
                            mBtnToolbarSend.setText(UIUtils.getString(R.string.delete) + "(" + mSelectedData.size() + ")");
                        } else {
                            mBtnToolbarSend.setEnabled(false);
                            mBtnToolbarSend.setText(UIUtils.getString(R.string.delete));
                        }
                    });
                }
            };
            mAdapter.setOnItemClickListener((helper, parent, itemView, position) -> {
                UserInfo userInfo = DBManager.getInstance().getUserInfo(mData.get(position).getUserId());
                if (userInfo != null) {
                    Intent intent = new Intent(RemoveGroupMemberActivity.this, UserInfoActivity.class);
                    intent.putExtra("userInfo", userInfo);
                    jumpToActivity(intent);
                }
            });
            mRvMember.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChangedWrapper();
        }
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_remove_group_member;
    }

}
