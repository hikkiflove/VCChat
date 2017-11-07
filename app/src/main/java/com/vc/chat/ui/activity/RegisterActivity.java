package com.vc.chat.ui.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.vc.chat.R;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.presenter.RegisterAtPresenter;
import com.vc.chat.ui.view.IRegisterAtView;
import com.vc.chat.util.UIUtils;

import butterknife.BindView;

/**
 * @author Hikki
 *         注册界面
 */
public class RegisterActivity extends BaseActivity<IRegisterAtView, RegisterAtPresenter> implements IRegisterAtView {

    @BindView(R.id.etNick)
    EditText mEtNick;
    @BindView(R.id.vLineNick)
    View mVLineNick;

    @BindView(R.id.etUserName)
    EditText mEtUserName;
    @BindView(R.id.vLineUserName)
    View mVLineUserName;

    @BindView(R.id.etPwd)
    EditText mEtPwd;
    @BindView(R.id.ivSeePwd)
    ImageView mIvSeePwd;
    @BindView(R.id.vLinePwd)
    View mVLinePwd;

    @BindView(R.id.btnRegister)
    Button mBtnRegister;

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mBtnRegister.setEnabled(canRegister());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    public void initListener() {
        mEtNick.addTextChangedListener(watcher);
        mEtPwd.addTextChangedListener(watcher);
        mEtUserName.addTextChangedListener(watcher);

        mEtNick.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                mVLineNick.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
                mVLineNick.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });
        mEtPwd.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                mVLinePwd.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
                mVLinePwd.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });
        mEtUserName.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                mVLineUserName.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
                mVLineUserName.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });

        mIvSeePwd.setOnClickListener(v -> {

            if (mEtPwd.getTransformationMethod() == HideReturnsTransformationMethod.getInstance()) {
                mEtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                mEtPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }

            mEtPwd.setSelection(mEtPwd.getText().toString().trim().length());
        });

        mBtnRegister.setOnClickListener(v -> {
            mPresenter.register();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

    private boolean canRegister() {
        int nickNameLength = mEtNick.getText().toString().trim().length();
        int pwdLength = mEtPwd.getText().toString().trim().length();
        int phoneLength = mEtUserName.getText().toString().trim().length();
        if (nickNameLength > 0 && pwdLength > 0 && phoneLength > 0) {
            return true;
        }
        return false;
    }

    @Override
    protected RegisterAtPresenter createPresenter() {
        return new RegisterAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    public EditText getEtNickName() {
        return mEtNick;
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
