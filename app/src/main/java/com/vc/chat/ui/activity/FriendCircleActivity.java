package com.vc.chat.ui.activity;

import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.presenter.FriendCircleAtPresenter;
import com.vc.chat.ui.view.IFriendCircleAtView;

/**
 * @author CSDN_LQR
 *         朋友圈
 */
public class FriendCircleActivity extends BaseActivity<IFriendCircleAtView, FriendCircleAtPresenter> implements IFriendCircleAtView {

    @Override
    protected FriendCircleAtPresenter createPresenter() {
        return new FriendCircleAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return 0;
    }
}
