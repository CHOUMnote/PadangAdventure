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

//메인 화면
public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    int count = 0;
    ImageView hawawa;
    Intent first;
    TextView nameBlank;
    //UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BgmPlayer bgm = new BgmPlayer();        //배경음악
        hawawa = findViewById(R.id.MAIN_touch_event);
        nameBlank = findViewById(R.id.name_blank);
        //File logCheck = new File(getFilesDir() + "LogIn.txt");

        if (!(new File(getFilesDir() + "/name.txt").exists())){
            first = new Intent(this, NameActivity.class);
            startActivityForResult(first, 1);
        }else{
            try {
                BufferedReader nameReader = new BufferedReader(new FileReader(getFilesDir() + "/name.txt"));
                final String name = nameReader.readLine();
                Toast.makeText(this, name+"님 또뵙네요", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*if (logCheck.exists()) {
             try {
                BufferedReader br = new BufferedReader(new FileReader(getFilesDir() + "LogIn.txt"));
                userData = new UserData(br.readLine()+"");
                nameBlank.setText(br.readLine() + "님 환영합니다.");
                Toast.makeText(this, "안녕하세요 " + br.readLine()+ "님 파댕월드에 오신걸 환영합니다.", Toast.LENGTH_LONG).show();
                br.close();
            } catch (Exception e) {
                e.printStackTrace();            }
        } else {
            first = new Intent(this, NameActivity.class);//이름입력
            startActivityForResult(first, 1);
            }*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//시작 일름 검색
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String name = data.getStringExtra("name");//적은 이름 저장
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "/name.txt", true));
                    bw.write(name);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    /*try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + name + ".txt", true));
                        BufferedReader bReader = new BufferedReader(new FileReader(getFilesDir() + name + ".txt"));
                        BufferedWriter login = new BufferedWriter(new FileWriter(getFilesDir() + "LogIn.txt", true));//로그인 기록
                        bw.write(name+"");
                        login.write(name+"");
                        userData = new UserData(bReader.readLine()+"");
                        bw.close();
                        bReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                nameBlank.setText(name + "님 환영합니다.");
                Toast.makeText(this, "안녕하세요 " + name + "님 파댕월드에 오신걸 환영합니다.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void hide_event(View v) { //이스터에그
        count++;
        //File file = new File(getFilesDir() + "achive_1.txt");
        if (count == 20)
            if (new File(getFilesDir() + "/achive1.txt").exists()) {
            } else {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "/achive1.txt", true));
                    bw.write("하와와 여고생쟝인 거시야요~");
                    bw.close();
                    Toast.makeText(this, "업적 +1!!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "경고! : " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        if (count > 19) {
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
