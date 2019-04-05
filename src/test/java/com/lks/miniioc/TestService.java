package com.lks.miniioc;

/**
 * Created by likaisong on 2019/3/21.
 */
public class TestService {
    private String text;

    private ReferenceService referenceService;

    public void hello(){
        referenceService.output();
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setReferenceService(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }
}
