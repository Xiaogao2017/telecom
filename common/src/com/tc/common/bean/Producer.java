package com.tc.common.bean;

import java.io.Closeable;

/**
 * @author Mr. Li xiaogao 2020-05-29 20:15
 * 生产者接口
 */
public interface Producer extends Closeable {
    //数据来源
    public void setIn(DataIn in);
    //数据目的地
    public void setOut(DataOut out);
    //生产数据
    public void produce();
}
