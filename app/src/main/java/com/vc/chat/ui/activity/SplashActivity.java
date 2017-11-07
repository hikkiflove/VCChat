package com.vc.chat.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.jaeger.library.StatusBarUtil;
import com.vc.chat.R;
import com.vc.chat.model.cache.UserCache;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.base.BasePresenter;
import com.vc.chat.util.UIUtils;

import butterknife.BindView;
import kr.co.namee.permissiongen.PermissionGen;

/**
 * @author Hikki
 *         闪屏页
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.rlButton) RelativeLayout mRlButton;
    @BindView(R.id.btnLogin) Button mBtnLogin;
    @BindView(R.id.btnHelp) Button mBtnHelp;

    @Override
    public void init() {
        PermissionGen.with(this)
                .addRequestCode(100)
                .permissions(
                        //电话通讯录
                        Manifest.permission.GET_ACCOUNTS,
                        Manifest.permission.READ_PHONE_STATE,
                        //位置
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        //相机、麦克风
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.WAKE_LOCK,
                        Manifest.permission.CAMERA,
                        //存储空间
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_SETTINGS
                )
                .request();
        if (!TextUtils.isEmpty(UserCache.getToken())) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            jumpToActivity(intent);
            finish();
        }
    }

    @Override
    public void initView() {
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.black));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(1000);
        mRlButton.startAnimation(alphaAnimation);
    }

    @Override
    public void initListener() {
        mBtnLogin.setOnClickListener(v -> {
            jumpToActivity(LoginActivity.class);
            finish();
        });
        mBtnHelp.setOnClickListener(v -> {
            //jumpToActivity(RegisterActivity.class);
            //TODO help activity
            finish();
        });
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_splash;
    }
}
