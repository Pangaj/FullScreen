package com.example.pangaj.fullscreenapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnFullScreen;
    Boolean isFullScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFullScreen = (Button) findViewById(R.id.btn_full_screen);
        btnFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFullScreen(isFullScreen);
                isFullScreen = !isFullScreen;
            }
        });

    }

    private void showFullScreen(Boolean fullscreen) {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        if (fullscreen) {
            attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
        } else {
            attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
            if (getSupportActionBar() != null) {
                getSupportActionBar().show();
            }
        }
        getWindow().setAttributes(attrs);
    }
}
