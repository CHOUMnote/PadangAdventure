package com.example.padangadventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainGame extends AppCompatActivity {
    Switch bgmContorl;
    TextView tv;
    UserData user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start);
        final BgmPlayer bgm = new BgmPlayer();
        bgmContorl = findViewById(R.id.sound_of);
        bgmContorl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bgm.checkSound();
            }
        });
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(getFilesDir()+"/name.txt"));
            user = new UserData(br.readLine()+"");
            br.close();
        } catch (Exception e) { }
        //유저정보 넘어오는거 확인
        tv = findViewById(R.id.aa);
        tv.setText(user.getName());
    }
    class BgmPlayer{//브금 컨트롤
        MediaPlayer mp;
        BgmPlayer() {
            mp = MediaPlayer.create(MainGame.this, R.raw.galrio_bgm);
            mp.setLooping(true);
            mp.start();
        }
        private void checkSound(){
            if(bgmContorl.isChecked()) {
                mp.setLooping(true);
                mp.start();
            }
            else{
                mp.pause();
            }
        }
    }
}