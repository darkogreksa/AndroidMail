package com.example.pmsumail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startLoginActivity();
    }

    private void startLoginActivity(){
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Log.e("TAG", "SplashActivity --- > onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.e("TAG", "SplashActivity --- > onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.e("TAG", "SplashActivity --- > onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e("TAG", "SplashActivity --- > onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("TAG", "SplashActivity --- > onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("TAG", "SplashActivity --- > onDestroy");
        super.onDestroy();
    }
}
