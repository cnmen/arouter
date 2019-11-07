package com.cmonbaby.arouter.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.cmonbaby.arouter.annotation.ARouter;
import com.cmonbaby.arouter.core.RouterManager;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        RouterManager.getInstance()
                .build("/library/LibraryActivity")
                .withString("name", "simon")
                .navigation(this, 666);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 666 && resultCode == RESULT_OK) {
            if (data == null) return;
            Toast.makeText(this, "pwd > " + data.getStringExtra("pwd"), Toast.LENGTH_SHORT).show();
        }
    }
}
