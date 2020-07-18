package com.tc.common.bean;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * @author Mr. Li xiaogao 2020-05-29 20:17
 * 数据来源
 */
public interface DataIn extends Closeable {
    //路径
    public void setPath(String path);
    //读取数据
    public Object read() throws IOException;
    public <T extends Data>List<T> read(Class<T> cla) throws IOException;

}
