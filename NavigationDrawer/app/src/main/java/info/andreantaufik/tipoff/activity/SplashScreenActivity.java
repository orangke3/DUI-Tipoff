package info.andreantaufik.tipoff.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import info.andreantaufik.tipoff.R;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_splash_screen);

                new Handler().postDelayed(new Runnable() {
                    @Override
            public void run(){
                //SPLASH SCREEN GO TO LandingPage.java
                Intent h = new Intent(SplashScreenActivity.this, StartActivity.class);
                startActivity(h);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}