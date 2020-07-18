package com.tc.common.bean;

/**
 * @author Mr. Li xiaogao 2020-05-29 20:21
 * 数据对象
 */
public abstract class Data implements Value {
    //数据内容content
    public String content;


    @Override
    public void setValue(Object value) {
        this.content = (String) value;
    }

    @Override
    public String getValue() {
        return content;
    }
}
