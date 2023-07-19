package com.example.test01.util;

import android.content.Context;

public class Utils {
    public static int dip2px(Context context,float dpvalue){

//        dp:与密度无关的像素 1英寸160个
//        dpi(density):每英寸有多少个像素点
//          px(个) = dpi(个/英寸) * (dp/160)(英寸)
        float scale = context.getResources().getDisplayMetrics().density;
        return  (int)(scale * dpvalue +0.5f);
    }
}

