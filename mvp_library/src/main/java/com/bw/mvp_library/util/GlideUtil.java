package com.bw.mvp_library.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

/*
 * @ClassName GlideUtil
 * @Description TODO
 * @Date 2021/8/12 14:28
 * @Version 1.0
 */
public class GlideUtil {
    public GlideUtil() {
    }

    private static volatile GlideUtil glideUtil;

    public static synchronized GlideUtil getInstance() {
        if (glideUtil == null){
            synchronized (GlideUtil.class){
                if (glideUtil == null){
                    glideUtil = new GlideUtil();
                }
            }
        }
        return glideUtil;
    }

    public void show(Context context, String url, ImageView img){
        Glide.with(context).load(url).into(img);
    }

    public void showCircle(Context context, String url, ImageView img){
        Glide.with(context).load(url).transform(new CircleCrop()).into(img);
    }

    public void showRounded(Context context, String url, ImageView img){
        Glide.with(context).load(url).transform(new RoundedCorners(50)).into(img);
    }
}
