package com.vc.chat.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;

import com.lqr.recyclerview.LQRRecyclerView;
import com.vc.chat.R;
import com.vc.chat.app.AppConst;
import com.vc.chat.manager.BroadcastManager;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.presenter.GroupListAtPresenter;
import com.vc.chat.ui.view.IGroupListAtView;

import butterknife.BindView;

/**
 * @author Hikki
 *         群聊列表界面
 */
public class GroupListActivity extends BaseActivity<IGroupListAtView, GroupListAtPresenter> implements IGroupListAtView {

    @BindView(R.id.llGroups)
    LinearLayout mLlGroups;
    @BindView(R.id.rvGroupList)
    LQRRecyclerView mRvGroupList;

    @Override
    public void init() {
        registerBR();
    }

    @Override
    public void initData() {
        mPresenter.loadGroups();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterBR();
    }

    private void registerBR() {
        BroadcastManager.getInstance(this).register(AppConst.GROUP_LIST_UPDATE, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mPresenter.loadGroups();
            }
        });
    }

    private void unRegisterBR() {
        BroadcastManager.getInstance(this).unregister(AppConst.GROUP_LIST_UPDATE);
    }

    @Override
    protected GroupListAtPresenter createPresenter() {
        return new GroupListAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_group_list;
    }

    @Override
    public LinearLayout getLlGroups() {
        return mLlGroups;
    }

    @Override
    public LQRRecyclerView getRvGroupList() {
        return mRvGroupList;
    }
}
