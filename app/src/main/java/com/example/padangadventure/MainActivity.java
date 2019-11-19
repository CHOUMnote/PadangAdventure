package com.example.padangadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

//메인 화면
public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    int count = 0;
    ImageView hawawa;
    Button reset;
    Intent first;
    TextView nameBlank;
    String name;
    String[] strToken;
    UserData user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BgmPlayer bgm = new BgmPlayer();        //배경음악
        hawawa = findViewById(R.id.MAIN_touch_event);
        nameBlank = findViewById(R.id.name_blank);
        reset = findViewById(R.id.reset);


                //File logCheck = new File(getFilesDir() + "LogIn.txt");
        if (!(new File(getFilesDir() + "/name.txt").exists())){//없으면...
            first = new Intent(this, NameActivity.class);
            startActivityForResult(first, 1);
        }else{//있으면...
            try {
                BufferedReader nameReader = new BufferedReader(new FileReader(getFilesDir() + "/name.txt"));
                name = nameReader.readLine();
                nameReader.close();
                strToken = name.split(" ");
//                user = new UserData(strToken[strToken.length-1]);
//                Toast.makeText(this, user.getName()+"님 환영합니다.", Toast.LENGTH_SHORT).show();
//                nameBlank.setText(user.getName() + "님 환영합니다.");
            } catch (IOException e) {   }
            user = new UserData(strToken[strToken.length-1]);
            Toast.makeText(this, user.getName()+"님 환영합니다.", Toast.LENGTH_SHORT).show();
            nameBlank.setText(user.getName() + "님 환영합니다.");
        }
    }

    public void nameReset(View v){
        first = new Intent(this, NameActivity.class);
        startActivityForResult(first, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//시작 이름 검색
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                name = data.getStringExtra("name");//적은 이름 저장
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "/name.txt", true));
                    bw.write(name);
                    bw.close();
                    BufferedReader nameReader = new BufferedReader(new FileReader(getFilesDir() + "/name.txt"));
                    strToken = nameReader.readLine().split(" ");
                    nameReader.close();
                } catch (IOException e) {   }
                user = new UserData(strToken[strToken.length-1]);
                nameBlank.setText(user.getName() + "님 환영합니다.");
                Toast.makeText(this, "안녕하세요 " + user.getName() + "님 파댕월드에 오신걸 환영합니다.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void hide_event(View v) { //이스터에그
        count++;
        //File file = new File(getFilesDir() + "achive_1.txt");
        if (count == 10)
            if (new File(getFilesDir() + "/achive1.txt").exists()) {
            } else {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "/achive1.txt", true));
                    bw.write(UserData.getName());
                    bw.close();
                    Toast.makeText(this, "업적 +1!!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(this, "경고! : " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        if (count > 9) {
            hawawa.setImageResource(R.drawable.girl_padang2);
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    hawawa.setImageResource(R.drawable.girl_padang);
                }
            };
            thread1.start();
        }
    }

        public void gameStart(View v){ //게임 시작
            Intent intent = new Intent(this, MainGame.class);
            startActivity(intent);
            mp.pause();
        }
        public void onClick_achive (View v){//업적 이동
            Intent intent = new Intent(this, AchevementList.class);
            startActivity(intent);
        }
        public void mOnPopupClick (View v){//저작권 이동
            Intent intent = new Intent(this, PopupActivity.class);
            startActivity(intent);
        }

        public class BgmPlayer {     //음악재생
            BgmPlayer() {
                mp = MediaPlayer.create(MainActivity.this, R.raw.galrio_bgm);
                mp.setLooping(true);
                mp.start();
            }
        }
    }