package com.vc.chat.ui.activity;

import android.view.View;

import com.lqr.optionitemview.OptionItemView;
import com.vc.chat.R;
import com.vc.chat.app.AppConst;
import com.vc.chat.app.MyApp;
import com.vc.chat.model.cache.UserCache;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.base.BasePresenter;
import com.vc.chat.widget.CustomDialog;

import butterknife.BindView;
import io.rong.imlib.RongIMClient;

/**
 * @author Hikki
 *         设置界面
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.oivAbout)
    OptionItemView mOivAbout;
    @BindView(R.id.oivHelpFeedback)
    OptionItemView mOivHelpFeedback;
    @BindView(R.id.oivExit)
    OptionItemView mOivExit;
    private View mExitView;
    private CustomDialog mExitDialog;

    @Override
    public void initListener() {
        mOivAbout.setOnClickListener(v -> jumpToActivity(AboutActivity.class));
        mOivHelpFeedback.setOnClickListener(v1 -> jumpToWebViewActivity(AppConst.WeChatUrl.HELP_FEED_BACK));
        mOivExit.setOnClickListener(v -> {
            if (mExitView == null) {
                mExitView = View.inflate(this, R.layout.dialog_exit, null);
                mExitDialog = new CustomDialog(this, mExitView, R.style.MyDialog);
                mExitView.findViewById(R.id.tvExitAccount).setOnClickListener(v1 -> {
                    RongIMClient.getInstance().logout();
                    UserCache.clear();
                    mExitDialog.dismiss();
                    MyApp.exit();
                    jumpToActivityAndClearTask(LoginActivity.class);
                });
                mExitView.findViewById(R.id.tvExitApp).setOnClickListener(v1 -> {
                    RongIMClient.getInstance().disconnect();
                    mExitDialog.dismiss();
                    MyApp.exit();
                });
            }
            mExitDialog.show();
        });
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_setting;
    }
}
