package com.cmonbaby.arouer.demo.library.impl;

import com.cmonbaby.arouer.demo.library.R;
import com.cmonbaby.arouer.demo.library.api.OpenApi;
import com.cmonbaby.arouter.annotation.ARouter;

@ARouter(path = "/library/DrawableImpl")
public class DrawableImpl implements OpenApi {

    @Override
    public int getDrawable() {
        return R.drawable.ic_android_black_60dp;
    }
}
