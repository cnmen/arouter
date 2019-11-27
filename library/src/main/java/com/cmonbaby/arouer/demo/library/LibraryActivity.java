package com.cmonbaby.arouer.demo.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cmonbaby.arouer.demo.library.bean.PersonalInfo;
import com.cmonbaby.arouter.annotation.ARouter;
import com.cmonbaby.arouter.annotation.Parameter;
import com.cmonbaby.arouter.core.ParameterManager;
import com.cmonbaby.arouter.core.RouterManager;

@ARouter(path = "/library/LibraryActivity")
public class LibraryActivity extends AppCompatActivity {

    @Parameter // Parameter name = Field name
    String name;

    @Parameter(name = "totalCount") // Custom parameter name
    int count;

    @Parameter
    PersonalInfo info; // Javabean (must be 'implements Serializable or Parcelable')

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ParameterManager.getInstance().loadParameter(this); // Lazy loading
        Log.e("simon >>> ", "name > " + name + " / count > " + count);
    }

    public void click(View view) {
        RouterManager.getInstance()
                .build("/app/MainActivity")
                .withResultString("pwd", "123")
                .navigation(this);
    }
}
