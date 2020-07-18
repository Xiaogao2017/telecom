package com.tc.common.bean;

import java.io.Closeable;

/**
 * @author Mr. Li xiaogao 2020-05-29 20:18
 *
 */
public interface DataOut extends Closeable {
    //路径
    public void setPath(String path);
    //
    public void write(Object data) throws Exception;
    public void write(String data) throws Exception;
}
