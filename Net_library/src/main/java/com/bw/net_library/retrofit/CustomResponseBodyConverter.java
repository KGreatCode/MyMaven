package com.bw.net_library.retrofit;

import com.bw.net_library.protocol.BaseRespEntry;
import com.bw.net_library.protocol.TokenRespEntry;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @package:com.bw.net.retrofit
 * @fileName:CustomResponseBodyConverter
 * @date on:2021/8/20 9:06
 */
public class CustomResponseBodyConverter <T> implements Converter<ResponseBody,T> {

    @Override
    public T convert(ResponseBody value) throws IOException {
        String jsonContent = value.string();
        if(jsonContent.contains("access_")){
            return (T)new Gson().fromJson(jsonContent, TokenRespEntry.class);
        }
        BaseRespEntry entry = new Gson().fromJson(jsonContent, BaseRespEntry.class);
        return (T)entry  ;
    }
}
