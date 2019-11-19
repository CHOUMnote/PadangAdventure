package com.example.padangadventure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends Activity {

    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.save_name);

        //UI 객체생성
        name = findViewById(R.id.editText);
    }

    //확인 버튼 클릭
    public void nameOnClose(View v){
        //데이터 전달하기
        if(name.getText()+"" != "") {
            Intent intent = new Intent();
            intent.putExtra("name", name.getText() + " ");
            setResult(RESULT_OK, intent);

            //액티비티(팝업) 닫기
            finish();
        }
        else{
            Toast.makeText(this, "정확히 입력해 주세요", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}