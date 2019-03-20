package com.example.pmsumail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD:app/src/main/java/com/example/pmsumail/SplashActivity.java
import android.widget.ImageView;
=======
import android.util.Log;
>>>>>>> 6305fc91ffaf1da1baa4cb5736462f3fd8d14d0c:PMSUMail/app/src/main/java/com/example/pmsumail/SplashActivity.java

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startLoginActivity();

        //addPreferencesFromResource

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
    protected void onDestroy() {super.onDestroy();
    }
}
