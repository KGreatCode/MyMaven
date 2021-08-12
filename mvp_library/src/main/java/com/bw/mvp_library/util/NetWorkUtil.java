package com.bw.mvp_library.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*
 * @ClassName NetWorkUtil
 * @Description TODO
 * @Date 2021/8/12 13:52
 * @Version 1.0
 */
public class NetWorkUtil {
    public NetWorkUtil() {
    }

    private static volatile NetWorkUtil netWorkUtil;

    public static synchronized NetWorkUtil getInstance() {
        if (netWorkUtil == null){
            synchronized (NetWorkUtil.class){
                if (netWorkUtil == null){
                    netWorkUtil = new NetWorkUtil();
                }
            }
        }
        return netWorkUtil;
    }

    public boolean isNetWork(Context context){
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo != null){
            return activeNetworkInfo.isConnected();
        }else {
            return false;
        }
    }
}
