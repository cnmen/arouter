package com.cmonbaby.arouter.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cmonbaby.arouer.demo.library.api.OpenApi;
import com.cmonbaby.arouter.annotation.ARouter;
import com.cmonbaby.arouter.annotation.Parameter;
import com.cmonbaby.arouter.core.ParameterManager;
import com.cmonbaby.arouter.core.RouterManager;

@ARouter(path = "/app/MainActivity") // Add class annotation as route
public class MainActivity extends AppCompatActivity {

    @Parameter(name = "/library/DrawableImpl")
    OpenApi drawable; // Public interface (must be 'extends Call')

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParameterManager.getInstance().loadParameter(this); // Lazy loading

        // Init view
        ImageView imageView = findViewById(R.id.img);
        imageView.setImageResource(drawable.getDrawable());

        // Click event
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }

    public void click() {
        RouterManager.getInstance() // Singleton
                // Arouter path
                .build("/library/LibraryActivity")
                // String
                .withString("name", "simon")
                // Basic data type
                .withInt("totalCount", 2333)
                .withBoolean("wasOldMan", true)
                // .withByte("key", value)
                // .withChar("key", value)
                // .withDouble("key", value)
                // .withFloat("key", value)
                // .withLong("key", value)
                // .withShort("key", value)
                // Serializable and Parcelable
                // .withSerializable("key", value)
                // .withParcelable("key", value)
                // Bundle
                // .withBundle("key", value)
                // Activate the callback
                // .withResultString("key", value)
                // Intent jump
                // .navigation(this, requestCode) // startActivityForResult()
                .navigation(this, 666);
                // .navigation(this, resultCode) // setResult() + finish()
                // .navigation(this); // startActivity()
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Listener callback
        if (requestCode == 666 && resultCode == RESULT_OK) {
            if (data == null) return;
            Toast.makeText(this, "pwd > " + data.getStringExtra("pwd"), Toast.LENGTH_SHORT).show();
        }
    }
}
