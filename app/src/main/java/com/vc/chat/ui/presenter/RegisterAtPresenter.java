package com.vc.chat.ui.presenter;

import android.text.TextUtils;

import com.vc.chat.R;
import com.vc.chat.api.ApiRetrofit;
import com.vc.chat.app.AppConst;
import com.vc.chat.model.cache.UserCache;
import com.vc.chat.model.exception.ServerException;
import com.vc.chat.model.response.CheckPhoneResponse;
import com.vc.chat.model.response.LoginResponse;
import com.vc.chat.model.response.RegisterResponse;
import com.vc.chat.model.response.SendCodeResponse;
import com.vc.chat.model.response.VerifyCodeResponse;
import com.vc.chat.ui.activity.LoginActivity;
import com.vc.chat.ui.activity.MainActivity;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.base.BasePresenter;
import com.vc.chat.ui.view.IRegisterAtView;
import com.vc.chat.util.LogUtils;
import com.vc.chat.util.RegularUtils;
import com.vc.chat.util.UIUtils;

import java.util.Timer;
import java.util.TimerTask;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RegisterAtPresenter extends BasePresenter<IRegisterAtView> {

    private Subscription mSubscription;

    public RegisterAtPresenter(BaseActivity context) {
        super(context);
    }

    public void register() {
        String username = getView().getEtUserName().getText().toString().trim();
        String password = getView().getEtPwd().getText().toString().trim();
        String nickName = getView().getEtNickName().getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            UIUtils.showToast(UIUtils.getString(R.string.username_not_empty));
            return;
        }

        if (TextUtils.isEmpty(password)) {
            UIUtils.showToast(UIUtils.getString(R.string.password_not_empty));
            return;
        }
        if (TextUtils.isEmpty(nickName)) {
            UIUtils.showToast(UIUtils.getString(R.string.nickname_not_empty));
            return;
        }
        //TODO, need add register function
        /*ApiRetrofit.getInstance().verifyCode(AppConst.REGION, username, code)
                .flatMap(new Func1<VerifyCodeResponse, Observable<RegisterResponse>>() {
                    @Override
                    public Observable<RegisterResponse> call(VerifyCodeResponse verifyCodeResponse) {
                        int code = verifyCodeResponse.getCode();
                        if (code == 200) {
                            return ApiRetrofit.getInstance().register(nickName, password, verifyCodeResponse.getResult().getVerification_token());
                        } else {
                            return Observable.error(new ServerException(UIUtils.getString(R.string.vertify_code_error) + code));
                        }
                    }
                })
                .flatMap(new Func1<RegisterResponse, Observable<LoginResponse>>() {
                    @Override
                    public Observable<LoginResponse> call(RegisterResponse registerResponse) {
                        int code = registerResponse.getCode();
                        if (code == 200) {
                            return ApiRetrofit.getInstance().login(AppConst.REGION, username, password);
                        } else {
                            return Observable.error(new ServerException(UIUtils.getString(R.string.register_error) + code));
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginResponse -> {
                    int responseCode = loginResponse.getCode();
                    if (responseCode == 200) {
                        UserCache.save(loginResponse.getResult().getId(), username, loginResponse.getResult().getToken());
                        mContext.jumpToActivityAndClearTask(MainActivity.class);
                        mContext.finish();
                    } else {
                        UIUtils.showToast(UIUtils.getString(R.string.login_error));
                        mContext.jumpToActivity(LoginActivity.class);
                    }
                }, this::registerError);*/
    }

    private void registerError(Throwable throwable) {
        LogUtils.sf(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
    }

    public void unsubscribe() {
        if (mSubscription != null) {
            mSubscription.unsubscribe();
            mSubscription = null;
        }
    }

}
