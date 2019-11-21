package com.example.padangadventure;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.ServerSocket;

//업적화면
public class AchevementList extends AppCompatActivity{
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achive_lay);
        /* 위젯과 멤버변수 참조 획득 */
        mListView = findViewById(R.id.listView);

        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();
    }

    private void dataSetting() {
        //업적들
        MyAdapter mMyAdapter = new MyAdapter();
        BufferedReader br;
        String name;

        try{
            br = new BufferedReader(new FileReader(getFilesDir() + "/achive1.txt"));
            name = br.readLine();
            br.close();
            if (new File(getFilesDir() + "/achive1.txt").exists()) { //1번 하와와 여고생쟝
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.star), "하와와 여고생쟝", name+"님 달성");}
        }catch (Exception e){   }

        try{
            br = new BufferedReader(new FileReader(getFilesDir() + "/achive2.txt"));
            name = br.readLine();
            br.close();
            if (new File(getFilesDir() + "/achive2.txt").exists()) { //2번 오타쿠
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.star), "오타쿠", name+"님 달성");}
        }catch (Exception e){   }

        try{
            br = new BufferedReader(new FileReader(getFilesDir() + "/achive3.txt"));
            name = br.readLine();
            br.close();
            if (new File(getFilesDir() + "/achive2.txt").exists()) { //3번 일어마스터
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.star), "일어마스터??", name+"님 달성");}
        }catch (Exception e){   }

        try{
            br = new BufferedReader(new FileReader(getFilesDir() + "/end.txt"));
            name = br.readLine();
            br.close();
            if (new File(getFilesDir() + "/end.txt").exists()) { //3번 일어마스터
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.star), "엔딩", name+"님 최초로 클리어");}
        }catch (Exception e){   }




        /* 리스트뷰에 어댑터 등록 */
        mListView.setAdapter(mMyAdapter);
    }
}