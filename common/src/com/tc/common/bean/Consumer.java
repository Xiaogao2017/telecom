package com.tc.common.bean;

import java.io.Closeable;

/**
 * @author Mr. Li xiaogao 2020-05-31 17:07
 * 消费者接口
 */
public interface Consumer extends Closeable {
    /**
     * 消费数据
     */
    public void consumer();
}
