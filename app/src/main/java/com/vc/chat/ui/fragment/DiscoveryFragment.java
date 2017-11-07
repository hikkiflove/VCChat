package com.vc.chat.ui.fragment;

import com.lqr.optionitemview.OptionItemView;
import com.vc.chat.R;
import com.vc.chat.app.AppConst;
import com.vc.chat.ui.activity.MainActivity;
import com.vc.chat.ui.activity.ScanActivity;
import com.vc.chat.ui.base.BaseFragment;
import com.vc.chat.ui.presenter.DiscoveryFgPresenter;
import com.vc.chat.ui.view.IDiscoveryFgView;

import butterknife.BindView;

/**
 * @author Hikki
 *         发现界面
 */
public class DiscoveryFragment extends BaseFragment<IDiscoveryFgView, DiscoveryFgPresenter> implements IDiscoveryFgView {

    @BindView(R.id.oivScan)
    OptionItemView mOivScan;
    @BindView(R.id.oivShop)
    OptionItemView mOivShop;
    @BindView(R.id.oivGame)
    OptionItemView mOivGame;

    @Override
    public void initListener() {
        mOivScan.setOnClickListener(v -> ((MainActivity) getActivity()).jumpToActivity(ScanActivity.class));
        mOivShop.setOnClickListener(v -> ((MainActivity) getActivity()).jumpToWebViewActivity(AppConst.WeChatUrl.JD));
        mOivGame.setOnClickListener(v -> ((MainActivity) getActivity()).jumpToWebViewActivity(AppConst.WeChatUrl.GAME));
    }

    @Override
    protected DiscoveryFgPresenter createPresenter() {
        return new DiscoveryFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_discovery;
    }
}
