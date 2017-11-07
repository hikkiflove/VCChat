package com.vc.chat.ui.activity;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.vc.chat.R;
import com.vc.chat.model.cache.UserCache;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.presenter.AddFriendAtPresenter;
import com.vc.chat.ui.view.IAddFriendAtView;
import com.vc.chat.util.UIUtils;

import butterknife.BindView;

/**
 * @author Hikki
 *         添加朋友界面
 */

public class AddFriendActivity extends BaseActivity<IAddFriendAtView, AddFriendAtPresenter> implements IAddFriendAtView {

    @BindView(R.id.llSearchUser)
    LinearLayout mLlSearchUser;
    @BindView(R.id.tvAccount)
    TextView mTvAccount;

    @Override
    public void initView() {
        setToolbarTitle(UIUtils.getString(R.string.add_friend));
        mTvAccount.setText(UserCache.getId() + "");
    }

    @Override
    public void initListener() {
        mLlSearchUser.setOnClickListener(v -> jumpToActivity(SearchUserActivity.class));
    }

    @Override
    protected AddFriendAtPresenter createPresenter() {
        return new AddFriendAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_add_friend;
    }
}
