package com.company;

public class Validator {

    public static void check(boolean bedingung, String msg){
        if(bedingung){
            throw new IllegalArgumentException(msg);
        }
    }
}
