package com.threel.animeshqip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoPlayer extends AppCompatActivity {
    private String url = Demo.url;
    private String episode = Demo.episodes;
    private String name = Demo.name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);



        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.mpw_video_player);
       jcVideoPlayerStandard.setUp(url
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, name+" - "+episode);
    }
}