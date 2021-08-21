package com.sample.alc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.sample.alc.Mnt.Util;

public class ActivityIntro extends Activity {
    private static final String TAG = ActivityIntro.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Util.removeActivityAll();
        Util.addActivity(this);
        Handler timer = new Handler();
        timer.postDelayed(new Runnable(){ //2초후 쓰레드를 생성하는 postDelayed 메소드

            public void run(){
                Intent intent = new Intent(ActivityIntro.this, VideoActivity.class);
                startActivity(intent); //다음 액티비티 이동
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish(); // 이 액티비티를 종료
            }
        }, 2000); //2000은 2초를 의미한다.
    }
}
