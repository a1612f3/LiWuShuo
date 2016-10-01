package com.lxc.liwushuodemo.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lxc.liwushuodemo.MainActivity;
import com.lxc.liwushuodemo.R;

public class SplashActivity extends AppCompatActivity implements Handler.Callback{

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler(this);
        handler.sendEmptyMessageDelayed(100,3000);
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg.what==100) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return false;
    }
}
