package com.cmonbaby.arouer.demo.library.api;

import com.cmonbaby.arouter.core.listener.Call;

// open api, must be 'extends Call'
public interface OpenApi extends Call {

    int getDrawable();
}
