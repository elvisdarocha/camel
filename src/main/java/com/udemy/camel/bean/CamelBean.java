package com.udemy.camel.bean;

public class CamelBean {

    public String map2(String input){
        String newBody = input.replace(",", "*");
        return newBody;
    }
}
