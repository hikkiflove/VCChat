package com.vc.chat.api.redpacket;

import com.vc.chat.model.redpacket.SignModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Hikki
 *         云账户获取demo签名接口
 */

public interface SignService {

    @GET("api/demo-sign/")
    Call<SignModel> getSignInfo(@Query("uid") String userId, @Query("token") String token);
}
