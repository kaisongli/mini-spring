package com.lks.miniioc.io;


import java.net.URL;

/**
 * Created by likaisong on 2019/4/5.
 */
public class ResourceLoader {

    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
