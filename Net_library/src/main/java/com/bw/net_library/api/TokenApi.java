package com.bw.net_library.api;


import com.bw.net_library.protocol.TokenRespEntry;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @package:com.bw.net.api
 * @fileName:TokenApi
 * @date on:2021/8/20 8:53
 */
public interface TokenApi {
    @FormUrlEncoded
    @POST
    Call<TokenRespEntry> getToken(@Field("grant_type")String grant_type, @Field("username")String username, @Field("password")String password);
}
