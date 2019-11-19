package com.example.padangadventure;

public class UserData {
    public static String name;

    public UserData(String n){
        name = n;
    }

    public static String getName(){
        return name;
    }

    public static  void setName(String n){  name = n;    }
}
