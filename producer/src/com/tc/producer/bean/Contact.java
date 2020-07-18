package com.tc.producer.bean;

import com.tc.common.bean.Data;

/**
 * @author Mr. Li xiaogao 2020-05-29 21:12
 * 联系人
 */
public class Contact extends Data {
    private String tel;
    private String name;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setValue(Object value) {
        content = (String) value;
        String[] values = content.split("\t");
        setName(values[1]);
        setTel(values[0]);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "tel='" + tel + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
