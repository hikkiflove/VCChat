package com.vc.chat.ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lqr.recyclerview.LQRRecyclerView;
import com.vc.chat.R;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.presenter.NewFriendAtPresenter;
import com.vc.chat.ui.view.INewFriendAtView;
import com.vc.chat.util.UIUtils;

import butterknife.BindView;

/**
 * @author Hikki
 *         新的朋友界面
 */

public class NewFriendActivity extends BaseActivity<INewFriendAtView, NewFriendAtPresenter> implements INewFriendAtView {

    @BindView(R.id.llToolbarAddFriend)
    LinearLayout mLlToolbarAddFriend;
    @BindView(R.id.tvToolbarAddFriend)
    TextView mTvToolbarAddFriend;

    @BindView(R.id.llNoNewFriend)
    LinearLayout mLlNoNewFriend;
    @BindView(R.id.llHasNewFriend)
    LinearLayout mLlHasNewFriend;
    @BindView(R.id.rvNewFriend)
    LQRRecyclerView mRvNewFriend;

    @Override
    public void initView() {
        mLlToolbarAddFriend.setVisibility(View.VISIBLE);
        setToolbarTitle(UIUtils.getString(R.string.new_friend));
    }

    @Override
    public void initData() {
        mPresenter.loadNewFriendData();
    }

    @Override
    public void initListener() {
        mTvToolbarAddFriend.setOnClickListener(v -> jumpToActivity(AddFriendActivity.class));
    }

    @Override
    protected NewFriendAtPresenter createPresenter() {
        return new NewFriendAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_new_friend;
    }

    @Override
    public LinearLayout getLlNoNewFriend() {
        return mLlNoNewFriend;
    }

    @Override
    public LinearLayout getLlHasNewFriend() {
        return mLlHasNewFriend;
    }

    @Override
    public LQRRecyclerView getRvNewFriend() {
        return mRvNewFriend;
    }
}
