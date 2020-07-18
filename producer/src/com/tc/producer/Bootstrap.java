package com.tc.producer;

import com.tc.common.bean.Producer;
import com.tc.producer.bean.LocalFileProducer;
import com.tc.producer.io.LocalFileDataIn;
import com.tc.producer.io.LocalFileDataOut;

import java.io.IOException;

/**
 * @author Mr. Li xiaogao 2020-05-29 20:32
 * 启动对象
 */
public class Bootstrap {
    public static void main(String[] args) throws IOException {
//        if (args.length < 2){
//            System.out.println("系统参数路径错误，请按照指定格式传递：java -jar Produce.jar path1 path2 ");
//            System.exit(1);
//        }
        //构建生产者对象
        Producer producer = new LocalFileProducer();
        producer.setIn(new LocalFileDataIn("D:\\hadoopDemo\\telecom-data\\input\\contact.log"));
        producer.setOut(new LocalFileDataOut("D:\\hadoopDemo\\telecom-data\\output\\call.log"));
//        producer.setIn(new LocalFileDataIn(args[0]));
//        producer.setOut(new LocalFileDataOut(args[1]));
        //生产数据
        producer.produce();
        //关闭生产者对象
        producer.close();
    }
}
