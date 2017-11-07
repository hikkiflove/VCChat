package com.vc.chat.ui.presenter;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import com.vc.chat.R;
import com.vc.chat.api.ApiRetrofit;
import com.vc.chat.app.AppConst;
import com.vc.chat.model.response.GetUserInfoByIdResponse;
import com.vc.chat.model.response.GetUserInfoByPhoneResponse;
import com.vc.chat.ui.activity.UserInfoActivity;
import com.vc.chat.ui.base.BaseActivity;
import com.vc.chat.ui.base.BasePresenter;
import com.vc.chat.ui.view.ISearchUserAtView;
import com.vc.chat.util.LogUtils;
import com.vc.chat.util.RegularUtils;
import com.vc.chat.util.UIUtils;

import io.rong.imlib.model.UserInfo;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchUserAtPresenter extends BasePresenter<ISearchUserAtView> {

    public SearchUserAtPresenter(BaseActivity context) {
        super(context);
    }

    public void searchUser() {
        String content = getView().getEtSearchContent().getText().toString().trim();

        if (TextUtils.isEmpty(content)) {
            UIUtils.showToast(UIUtils.getString(R.string.content_no_empty));
            return;
        }

        mContext.showWaitingDialog(UIUtils.getString(R.string.please_wait));
        if (RegularUtils.isMobile(content)) {
            ApiRetrofit.getInstance().getUserInfoFromPhone(AppConst.REGION, content)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getUserInfoByPhoneResponse -> {
                        mContext.hideWaitingDialog();
                        if (getUserInfoByPhoneResponse.getCode() == 200) {
                            GetUserInfoByPhoneResponse.ResultEntity result = getUserInfoByPhoneResponse.getResult();
                            UserInfo userInfo = new UserInfo(result.getId(), result.getNickname(), Uri.parse(result.getPortraitUri()));
                            Intent intent = new Intent(mContext, UserInfoActivity.class);
                            intent.putExtra("userInfo", userInfo);
                            mContext.jumpToActivity(intent);
                        } else {
                            getView().getRlNoResultTip().setVisibility(View.VISIBLE);
                            getView().getLlSearch().setVisibility(View.GONE);
                        }
                    }, this::loadError);
        } else {
            ApiRetrofit.getInstance().getUserInfoById(content)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getUserInfoByIdResponse -> {
                        mContext.hideWaitingDialog();
                        if (getUserInfoByIdResponse.getCode() == 200) {
                            GetUserInfoByIdResponse.ResultEntity result = getUserInfoByIdResponse.getResult();
                            UserInfo userInfo = new UserInfo(result.getId(), result.getNickname(), Uri.parse(result.getPortraitUri()));
                            Intent intent = new Intent(mContext, UserInfoActivity.class);
                            intent.putExtra("userInfo", userInfo);
                            mContext.jumpToActivity(intent);
                        } else {
                            getView().getRlNoResultTip().setVisibility(View.VISIBLE);
                            getView().getLlSearch().setVisibility(View.GONE);
                        }
                    }, this::loadError);
        }
    }

    private void loadError(Throwable throwable) {
        mContext.hideWaitingDialog();
        LogUtils.sf(throwable.getLocalizedMessage());
    }
}
