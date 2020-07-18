package com.tc.common.constant;

import com.tc.common.bean.Value;

/**
 * @author Mr. Li xiaogao 2020-05-29 20:26
 * 名称常量枚举类   命名空间
 */
public enum Names implements Value {
    NAMESPACE("telecom")
    ,TOPIC("telecom")
    ,TABLE("telecom:callLog")
    ,CF_INFO("info")
    ,CF_CALLER("caller")
    ,CF_CALLEE("callee");//caller 主叫 callee 被叫

    private String name;
    private Names(String name){
        this.name = name;
    }


    @Override
    public void setValue(Object value) {
        this.name = (String) value;
    }

    @Override
    public String getValue() {
        return name;
    }
}
