package com.vc.chat.ui.presenter;

import android.text.TextUtils;

import com.vc.chat.R;
import com.vc.chat.api.ApiRetrofit;
import com.vc.chat.app.AppConst;
import com.vc.chat.model.cache.UserCache;
import com.vc.chat.model.exception.ServerException;
import com.vc.chat.ui.activity.MainActivity;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.base.BasePresenter;
import com.vc.chat.ui.view.ILoginAtView;
import com.vc.chat.util.LogUtils;
import com.vc.chat.util.UIUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginAtPresenter extends BasePresenter<ILoginAtView> {

    public LoginAtPresenter(BaseActivity context) {
        super(context);
    }

    public void login() {
        String userName = getView().getEtUserName().getText().toString().trim();
        String pwd = getView().getEtPwd().getText().toString().trim();

        if (TextUtils.isEmpty(userName)) {
            UIUtils.showToast(UIUtils.getString(R.string.username_not_empty));
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            UIUtils.showToast(UIUtils.getString(R.string.password_not_empty));
            return;
        }

        mContext.showWaitingDialog(UIUtils.getString(R.string.please_wait));

        if (userName.equals("hikki")) {
            mContext.hideWaitingDialog();
            mContext.jumpToActivityAndClearTask(MainActivity.class);
            mContext.finish();
        } else {
            loginError(new ServerException(UIUtils.getString(R.string.login_error)));
        }
        //TODO verity user name and password from server
        /*ApiRetrofit.getInstance().login(AppConst.REGION, userName, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginResponse -> {
                    int code = loginResponse.getCode();
                    mContext.hideWaitingDialog();
                    if (code == 200) {
                        UserCache.save(loginResponse.getResult().getId(), userName, loginResponse.getResult().getToken());
                        mContext.jumpToActivityAndClearTask(MainActivity.class);
                        mContext.finish();
                    } else {
                        loginError(new ServerException(UIUtils.getString(R.string.login_error) + code));
                    }
                }, this::loginError);*/
    }

    private void loginError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
        mContext.hideWaitingDialog();
    }
}
