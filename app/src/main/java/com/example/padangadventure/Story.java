package com.example.padangadventure;


import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Story {
    boolean choose;
    int count = 1;
    String user;
    TextView textView;
    ImageView img;
    Button yes,no;
    Boolean on = false;
    int score = 0;
    String a;
    File file;
    BufferedWriter br;

    public Story(UserData name, TextView textView, ImageView img, Button YES, Button NO, String a){
        user =  name.getName();     this.textView = textView;   this.img = img;     yes = YES;      no = NO; storyStart(); this.a = a;

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
        yes.setText(" ");
        no.setText(" ");
    }

    public File saveFile(File file){
        return file;
    }
    public void storyStart(){
        resetButton();
        switch (count){
            case 1: textView.setText("안녕 내이름은 파댕이!!!"); img.setImageResource(R.drawable.hi); break;
            case 2: textView.setText("한림대학교에 입학하였다!"); break;
            case 3: textView.setText("꿈에 그리던 대학 생활"); img.setImageResource(R.drawable.hechec);break;
            case 4: textView.setText("오늘은 오리엔테이션이 있는 날");  break;
            case 5:
                textView.setText("어쩌지? 오리엔테이션을 갈까?");
                img.setImageResource(R.drawable.gogo);
                setButton(true, "가즈아!!");
                setButton(false, "귀찮기 때문에 가지 않는다");
                on = true;
                break; //선택지 1
            case 6:
                if(choose) {
                    textView.setText("무사히 다녀왔다!! 그리고 칭구도 마니사기여따!!");
                    img.setImageResource(R.drawable.loveyou);
                }else {
                    textView.setText("친구들은 마니 사기지 못하여따... 하지만 걱정할거없다... ");
                    img.setImageResource(R.drawable.hoeeeee);    }
                on = false;
                break;
            case 7:
                if(choose)
                    textView.setText("오리엔테이션에서 사귄 친구인" + user);
                else {
                    textView.setText("상상속에서 친구를 사귄 친구 미쿠쨩!"); // 업적 미쿠쨩
                    if(!(new File(a+"/achive2.txt").exists())) {
                        file = new File(a + "/achive2.txt");
                        try {
                            br = new BufferedWriter(new FileWriter(file, true));
                            br.write(UserData.getName());
                            br.close();
                        }catch (Exception e){   }
                    }
                }
                img.setImageResource(R.drawable.chapchap);
                break;
            case 8:
                if(choose)
                    textView.setText(user+"와(과)는 정말 궁합이 좋은거같아!!");
                else
                    textView.setText("미쿠쨩을 아는 친구! "+user+"와 씹덕의 길로 들어가게 되어따!");
                break;
            case 9: textView.setText("(웅성웅성)"); img.setImageResource(R.drawable.naniii);break;
            case 10:
                textView.setText("밖에서 시끄러운 소리가 들린다.");
                if(!choose){
                    textView.setText("저기봐 오타쿠야 (웅성웅성)");
                    img.setImageResource(R.drawable.unzi);  }
                break;
            case 11: textView.setText("몇일후"); img.setImageResource(R.drawable.nameis); break;
            case 12: textView.setText("오늘은 동아리 홍보 하는 날이다."); break;
            case 13: textView.setText("운동,학술,취미 등등..."); break;
            case 14: textView.setText("여러 재미있는 동아리가 보였다. "); break;
            case 15: textView.setText("그 중 가장 흥미로워 보이는 동아리가 눈에 띄었다."); break;
            case 16:
                textView.setText("어쩌지 이 동아리에 들어갈까? ");
                img.setImageResource(R.drawable.naninani);
                setButton(true, "들어가자!");
                setButton(false, "들어가지 말자!");
                on = true;
                break; //선택지 2
            case 17:
                if(choose){
                    textView.setText("사실 회비만 탐내는 하자있는 동아리였다...");   }
                else{
                    textView.setText("아니다 뭔가 불안해 보인다. 다른 눈에 띄는 동아리가 보인다."); }
                on = false;
            case 18:
                if(choose) {
                    textView.setText("사실 회비만 탐내는 하자있는 동아리였고 돈만 뜯기고 탈주한 나였다... 그래도 전에 봐둔 동아리가 있어 가입했다");
                    img.setImageResource(R.drawable.ohmymoney);
                } else {
                    textView.setText("아니다 뭔가 불안해 보인다. 다른 눈에 띄는 동아리가 보인다. 옆에 눈에 동아리로 들어갔다");
                    img.setImageResource(R.drawable.titi);                }
                break;
            case 19:
                    textView.setText("'씨애랑' 동아리를 가입하게되었다! 엄청 힘들다지만 잘 할수 있을것 같다!"); //업적
                break;
            case 20: textView.setText("새로운 친구를 사귀면서 활동도 많이하고 놀러도 가면서 즐거웠다. 물론 여자친구가 있는건 아니다.");
                img.setImageResource(R.drawable.aiaiai);
                break;
            case 21: textView.setText("그래도 즐거운 대학생활을 보내던 도중 나에게 엄청난 일이 벌어지는데..."); break;
            case 22: textView.setText(user+" : 야 너 공부했어?"); img.setImageResource(R.drawable.naninani);break;
            case 23: textView.setText("무슨 공부? 먹는건가??"); break;
            case 24: textView.setText("냠냠~~"); img.setImageResource(R.drawable.uuueee); break;
            case 25: textView.setText(user+" : 몰랐어? 다음 주가 시험기간이잖아"); img.setImageResource(R.drawable.naniii); break;
            case 26: textView.setText("-그렇다 다음주엔 시험을 보는 것이였다.-"); break;
            case 27: textView.setText("갑작스레 다가온 중간고사"); break;
            case 28: textView.setText("지금부터라도 공부를 하겠다고 다짐한 파댕이"); img.setImageResource(R.drawable.hawawarani); break;
            case 29: textView.setText("갑자기 "+user+"가 PC방을 가자고 한다"); break;
            case 30: textView.setText("당연히 가야지 시즌 마지막인걸..."); img.setImageResource(R.drawable.heheheheh); break;
            case 31: textView.setText("(하지만 시즌 마지막으라 던지는 유저는 많았다고 한다... 그렇게 혈압겜을 했고"); img.setImageResource(R.drawable.firefire); break;
            case 32: textView.setText("왜 게임이 질병인지 알게된 하루였다. 그리고 시험날이 밝았다."); break;
            case 33: textView.setText("하지만 파댕이는 걱정이없다. 어짜피 시험은 '너'가 풀거다. "); img.setImageResource(R.drawable.kira); break;
            case 34:
                textView.setText("문제 : べつべつに計算お願いいたします。 ");
                setButton(true, "はい!");
                setButton(false, "ありがとうございました。");
                on = true;
                break;
            case 35:
                if(choose){
                    textView.setText("이시국에 이걸 맞춘다고?? 다음문제");
                    score++;    }
                else
                    textView.setText("모르는게 당연하다... 이시국에?");
                on = false;
                break;
            case 36:
                textView.setText("문제 : 君の名は。");
                setButton(true, "何言ってるん!");
                setButton(false, "パダンイです");
                on = true;
                break;
            case 37:
                if(!choose){
                    score++;
                    textView.setText("정답! 지금까지"+score+"/2 점"); }
                else
                    textView.setText("모르는게 당연...");
                on = false;
                break;
            case 38:
                textView.setText("문제 : 博多駅どこですか。。");
                setButton(true, "分からない。");
                setButton(false, "寿司がすき");
                on = true;
                break;
            case 39:
                if(choose){
                    score++;
                    if(score == 3)
                        if(!(new File(a+"/achive3.txt").exists())) {
                            file = new File(a + "/achive3.txt");
                            try {
                                br = new BufferedWriter(new FileWriter(file, true));
                                br.write(UserData.getName());
                                br.close();
                            }catch (Exception e){   }
                        }
                    textView.setText("지금까지"+score+"/3 점!! 수고했습니다 ^^ 문제는 여기까지입니다."); }
                else
                    textView.setText("수고했습니다 ^^ 문제는 여기까지입니다.");

                on = false;
                break;
            case 40: textView.setText("그렇게 무사히 시험을 마쳤다. 무려 "+score+"/3 점"); img.setImageResource(R.drawable.dedane); break;
            case 41: textView.setText("시험은 끝나고 2학기는 없습니다. 개발자가 만들지 않았죠");  img.setImageResource(R.drawable.trap); break;
            case 42:
                textView.setText("왜냐고요?");
                on = true;
                setButton(true, "노오오력이 부족하구나");
                setButton(false, "실력이 부족하구나");
                break;
            case 43:
                if(choose)
                    textView.setText("노오오오오오력이 부족하다고요??");
                else
                    textView.setText("1학년인걸 어떡합니까!!");
                on = false;
                break;
            case 44: textView.setText("불만입니까??");   break;
            case 45: textView.setText("으쩌라구요~~~"); img.setImageResource(R.drawable.fire);  break;
            case 46: textView.setText("아무튼 파댕이에게 꽤 많은 시간이 흘렀어요");  img.setImageResource(R.drawable.coooool); break;
            case 47: textView.setText("6개월 후..."); img.setImageResource(R.drawable.gooodmorning); break;
            case 48:
                textView.setText("편지가 왔다! 한번 꺼내볼까?");
                on = true;
                setButton(true, "러브레터???");
                setButton(false, "보나마나 공과금 청구서");
                break;
            case 49:
                if(choose)
                    textView.setText("★군대★에서 온 러브레터!!");
                else
                    textView.setText("공과금 청구서였으면 좋았을터... ");
                img.setImageResource(R.drawable.goonmer);
                on = false;
                break;
            case 50: textView.setText("파댕이는 군대를 가야해요..."); break;
            case 51: textView.setText("짧은 시간이였지만 이제는 긴 시간이 찾아온거에요");    break;
            case 52: textView.setText("지옥이라는 시간이요");    break;
            case 53:
                textView.setText("-----끝-----");
                if(!(new File(a+"/end.txt").exists())) {
                    file = new File(a + "/end.txt");
                    try {
                        br = new BufferedWriter(new FileWriter(file, true));
                        br.write(UserData.getName());
                        br.close();
                    }catch (Exception e){   }
                }
                img.setImageResource(R.drawable.ending);
        }
    }
}
