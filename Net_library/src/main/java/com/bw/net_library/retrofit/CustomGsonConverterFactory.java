package com.bw.net_library.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @package:com.bw.net.retrofit
 * @fileName:CusomGsonConverterFactory
 * @date on:2021/8/20 9:05
 */
public class CustomGsonConverterFactory extends Converter.Factory {
    public static CustomGsonConverterFactory create(){
        return new CustomGsonConverterFactory();
    }
    @Override
    public Converter<ResponseBody,?>responseBodyConverter(Type type, Annotation[]annotations, Retrofit retrofit){
        return new CustomResponseBodyConverter<>();
    }
    @Override
    public Converter<?, RequestBody>requestBodyConverter(Type type, Annotation[]parameterAnnotations,Annotation[]methodAnnotations, Retrofit retrofit){
        return new CustomRequestBodyConverter<>();
    }


}
