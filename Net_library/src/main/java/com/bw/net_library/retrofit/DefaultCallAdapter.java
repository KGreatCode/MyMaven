package com.bw.net_library.retrofit;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;

/**
 * @package:com.bw.net.retrofit
 * @fileName:DefaultCallAdapter
 * @date on:2021/8/20 9:07
 */
public class DefaultCallAdapter<R>implements CallAdapter<R,Object> {
    Type mType = null;

    public DefaultCallAdapter(Type _t) {
        mType = _t;
    }

    @Override
    public Type responseType() {
        return mType;
    }

    @Override
    public Object adapt(Call<R> call) {
        return call;
    }
}
