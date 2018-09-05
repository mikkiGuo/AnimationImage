package com.example.mikki.animationimage;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MotionActivity extends AppCompatActivity
{
    ImageView iv;
    // Animation
    Animation animFadein, animRotate;
    Button fadein_btn, rotate_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);

        iv = findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.wow);
        fadein_btn = findViewById(R.id.fadeIn);
        rotate_btn = findViewById(R.id.rotateBtn);

        // load the animation
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        fadein_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.startAnimation(animFadein);
            }
        });
        rotate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(animRotate);

            }
        });


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(MotionActivity.this, "landscape", Toast.LENGTH_LONG).show();

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(MotionActivity.this, "portrait", Toast.LENGTH_LONG).show();

        }
    }

}
