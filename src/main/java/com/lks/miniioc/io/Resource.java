package com.lks.miniioc.io;

import java.io.InputStream;

/**
 * Created by likaisong on 2019/4/5.
 */
public interface Resource {
    InputStream getInputStream() throws Exception;
}
