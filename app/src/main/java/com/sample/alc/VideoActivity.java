package com.sample.alc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.sample.alc.Mnt.Util;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    private static final String TAG = VideoActivity.class.getSimpleName();
    private VideoView vv = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Util.removeActivityAll();
        Util.addActivity(this);
        Uri uri = null;

        // get weather
//        if (날씨가 맑으면) { //날씨 API 얻어와서 적용
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample1);
//        } else if(날씨가 흐리면) {
//            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample);
//        } else if (비오면) {
//            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample);
//        }

        // create control
//        createControl();
        vv = findViewById(R.id.vv1);

        //동영상 Uri

        vv.setVideoURI(uri);
        MediaController mediaController = new MediaController(this); // 재생이나 정지와 같은 미디어 제어 버튼 담당
        vv.setMediaController(mediaController);
        mediaController.setAnchorView(vv);

        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //onBackPressed(); // 동영상 재생 종료시 activity 를 종료하고자 할때 사용
//                vv.start();
                Intent intent = new Intent(VideoActivity.this, MainActivity.class);
                startActivity(intent); //다음 액티비티 이동
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish(); // 이 액티비티를 종료
                return;
            }
        });
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                vv.start();
            }
        });
        vv.setOnTouchListener(new View.OnTouchListener(){
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(VideoActivity.this, MainActivity.class);
                startActivity(intent); //다음 액티비티 이동
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish(); // 이 액티비티를 종료
                return true;
            }
        });
    }

    private void createControl() {
        if (vv == null) {
            vv = findViewById(R.id.vv1);
        }
    }
}
