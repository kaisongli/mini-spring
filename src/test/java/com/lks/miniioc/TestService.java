package com.lks.miniioc;

/**
 * Created by likaisong on 2019/3/21.
 */
public class TestService {
    private String text;

    public void hello(){
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
