package com.vc.chat.ui.activity;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vc.chat.R;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.presenter.LoginAtPresenter;
import com.vc.chat.ui.view.ILoginAtView;
import com.vc.chat.util.LogUtils;
import com.vc.chat.util.UIUtils;

import butterknife.BindView;

/**
 * @author Hikki
 *         登录界面
 */
public class LoginActivity extends BaseActivity<ILoginAtView, LoginAtPresenter>
        implements ILoginAtView {

    @BindView(R.id.ibAddMenu) ImageButton mIbAddMenu;
    @BindView(R.id.loginName) EditText mEtUserName;
    @BindView(R.id.vLinePhone) View mVLinePhone;

    @BindView(R.id.etPwd) EditText mEtPwd;
    @BindView(R.id.vLinePwd) View mVLinePwd;

    @BindView(R.id.btnLogin) Button mBtnLogin;
    @BindView(R.id.common_help) TextView mCommonHelp;
    @BindView(R.id.common_config) TextView mCommonConfig;

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mBtnLogin.setEnabled(canLogin());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    public void initView() {
        mIbAddMenu.setVisibility(View.GONE);
    }

    @Override
    public void initListener() {
        mEtPwd.addTextChangedListener(watcher);
        mEtUserName.addTextChangedListener(watcher);
        mEtPwd.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                mVLinePwd.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
                mVLinePwd.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });
        mEtUserName.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                mVLinePhone.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
                mVLinePhone.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });
        mCommonHelp.setOnClickListener(v -> {
            //jumpToActivity(LoginActivity.class);
            //TODO jump to common help activity
            //finish();
            LogUtils.d("help on click");
        });
        mCommonConfig.setOnClickListener(v -> {
            //jumpToActivity(LoginActivity.class);
            //TODO jump to common config activity
            //finish();
            LogUtils.d("config on click");
        });

        mBtnLogin.setOnClickListener(v -> mPresenter.login());
    }

    private boolean canLogin() {
        int pwdLength = mEtPwd.getText().toString().trim().length();
        int userNameLength = mEtUserName.getText().toString().trim().length();
        if (pwdLength > 0 && userNameLength > 0) {
            return true;
        }
        return false;
    }


    @Override
    protected LoginAtPresenter createPresenter() {
        return new LoginAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public EditText getEtUserName() {
        return mEtUserName;
    }

    @Override
    public EditText getEtPwd() {
        return mEtPwd;
    }
}