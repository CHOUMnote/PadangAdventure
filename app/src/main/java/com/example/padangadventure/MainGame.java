package com.example.padangadventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainGame extends AppCompatActivity {
    Switch bgmContorl;
    UserData user;
    Story story;
    ConstraintLayout tt;
    TextView tv;
    Button YES,NO;
    ImageView img;
    BgmPlayer bgm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start);
        tv = findViewById(R.id.tv);
        img = findViewById(R.id.inImg);
        YES = findViewById(R.id.bnt_YES);
        NO = findViewById(R.id.bnt_NO);
        tt = findViewById(R.id.img_lay);
        bgm = new BgmPlayer();
        bgmContorl = findViewById(R.id.sound_of);
        bgmContorl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bgm.checkSound();
            }
        });

        story = new Story(user, tv, img, YES, NO, getFilesDir()+"");

        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //3의 버튼
                if (!story.on) {
                    story.count++;
                    story.storyStart();
                }
            }
        });
        YES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //예스 버튼
                if (story.on) {
                    story.count++;
                    story.choose = true;
                    story.storyStart();
                }
            }
        });
        NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //노 버튼
                if (story.on) {
                    story.count++;
                    story.choose = false;
                    story.storyStart();
                }
            }
        });

    }















    public void exit(View v){ //나가기
        bgm.mp.reset();
        bgm.mp.pause();
        finish();
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

    //@Override
    //public void onBackPressed() {
    //    //안드로이드 백버튼 막기
      //  return;
    //}
}