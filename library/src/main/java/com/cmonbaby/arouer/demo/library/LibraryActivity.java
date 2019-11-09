package com.cmonbaby.arouer.demo.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cmonbaby.arouter.annotation.ARouter;
import com.cmonbaby.arouter.annotation.Parameter;
import com.cmonbaby.arouter.core.ParameterManager;
import com.cmonbaby.arouter.core.RouterManager;

@ARouter(path = "/library/LibraryActivity")
public class LibraryActivity extends AppCompatActivity {

    @Parameter
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ParameterManager.getInstance().loadParameter(this); // Lazy loading
        Log.e("simon >>> ", name);
    }

    public void click(View view) {
        RouterManager.getInstance()
                .build("/app/MainActivity")
                .withResultString("pwd", "123")
                .navigation(this);
    }
}
