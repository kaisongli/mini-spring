package com.lks.miniioc.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by likaisong on 2019/4/5.
 */
public class UrlResource implements Resource{
    private final URL url;

    public UrlResource(URL url){
        this.url = url;
    }
    @Override
    public InputStream getInputStream() throws Exception {
        URLConnection connection = url.openConnection();
        connection.connect();
        return connection.getInputStream();
    }
}
