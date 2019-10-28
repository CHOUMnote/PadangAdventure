package com.example.padangadventure;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.File;

//업적화면
public class AchevementList extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achive_lay);

        /* 위젯과 멤버변수 참조 획득 */
        mListView = (ListView)findViewById(R.id.listView);

        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();
    }

    private void dataSetting() {
        //업적들
        File file = new File(getFilesDir() + "/achive1.txt"); //1번 하와와 여고생쟝

        MyAdapter mMyAdapter = new MyAdapter();
        if (file.exists()) {
            mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.star), "하와와", "여고생쟝");}

        /* 리스트뷰에 어댑터 등록 */
        mListView.setAdapter(mMyAdapter);
    }
}