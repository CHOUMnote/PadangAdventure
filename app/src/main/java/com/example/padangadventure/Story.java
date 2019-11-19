package com.example.padangadventure;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Story {
    boolean choose;
    int count = 0;
    String user;
    TextView textView;
    ConstraintLayout img;
    Button yes,no;

    public Story(UserData name, TextView textView, ConstraintLayout img, Button YES, Button NO){
        user =  name.getName();     this.textView = textView;   this.img = img;     yes = YES;      no = NO;
    }

    public void setText(String str){
        textView.setText(str);
    }
    public void resetText(){
        textView.setText("");
    }
    public void setButton(boolean a, String str) {
        if (a)// YES버튼
            yes.setText(str);
        else// NO버튼
            no.setText(str);
    }
    public void resetButton() {
        yes.setText("YES");
        no.setText("NO");
    }

    public void storyStart(){
        switch (count){
            case 1: textView.setText("안녕 내이름은" + user + "!"); break;
            case 2: textView.setText("한X대학교에 입학하였다!"); break;
            case 3: textView.setText("꿈에 그리던 대학 생활"); break;
            case 4: textView.setText("오늘은 오리엔테이션이 있는 날"); break;
            case 5: textView.setText("어쩌지? 오리엔테이션을 갈까?"); break; //선택지 1
            case 6:
            if(choose)
                textView.setText("무사히 친구를 사귀었다!");
            else {
                textView.setText("아싸가 되었다...");
                count = 0;
            }
            break;
            case 8: textView.setText("(웅성웅성)"); break;
            case 9: textView.setText("밖에서 시끄러운 소리가 들린다."); break;
            case 10: textView.setText("뭐지?"); break;
            case 11: textView.setText("밖을 보니 오늘은 동아리 홍보 하는 날이다."); break;
            case 12: textView.setText("운동,학술,취미 등등..."); break;
            case 13: textView.setText("여러 재미있는 동아리가 보였다. "); break;

        }
    }
}
