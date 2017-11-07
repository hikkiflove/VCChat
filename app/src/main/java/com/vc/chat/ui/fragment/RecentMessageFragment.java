package com.vc.chat.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.lqr.recyclerview.LQRRecyclerView;
import com.vc.chat.R;
import com.vc.chat.app.AppConst;
import com.vc.chat.manager.BroadcastManager;
import com.vc.chat.ui.activity.MainActivity;
import com.vc.chat.ui.base.BaseFragment;
import com.vc.chat.ui.presenter.RecentMessageFgPresenter;
import com.vc.chat.ui.view.IRecentMessageFgView;

import butterknife.BindView;

/**
 * @author Hikki
 *         最近会话列表界面
 */
public class RecentMessageFragment extends BaseFragment<IRecentMessageFgView, RecentMessageFgPresenter> implements IRecentMessageFgView {

    @BindView(R.id.rvRecentMessage)
    LQRRecyclerView mRvRecentMessage;
    private boolean isFirst = true;

    @Override
    public void init() {
        registerBR();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (!isFirst) {
            mPresenter.getConversations();
        }
    }

    @Override
    public void initData() {
//        UIUtils.postTaskDelay(() -> {
//        mPresenter.getConversations();
//        }, 1000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unRegisterBR();
    }

    private void registerBR() {
        BroadcastManager.getInstance(getActivity()).register(AppConst.UPDATE_CONVERSATIONS, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mPresenter.getConversations();
                isFirst = false;
            }
        });
    }

    private void unRegisterBR() {
        BroadcastManager.getInstance(getActivity()).unregister(AppConst.UPDATE_CONVERSATIONS);
    }

    @Override
    protected RecentMessageFgPresenter createPresenter() {
        return new RecentMessageFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_recent_message;
    }

    @Override
    public LQRRecyclerView getRvRecentMessage() {
        return mRvRecentMessage;
    }
}
