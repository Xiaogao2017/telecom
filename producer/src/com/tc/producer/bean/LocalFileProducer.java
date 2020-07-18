package com.tc.producer.bean;

import com.tc.common.bean.DataIn;
import com.tc.common.bean.DataOut;
import com.tc.common.bean.Producer;
import com.tc.common.util.DateUtil;
import com.tc.common.util.NumberUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Mr. Li xiaogao 2020-05-29 20:36
 * 本地数据文件的生成者
 */
public class LocalFileProducer implements Producer {

    private DataIn in;
    private DataOut out;
    //随机生成数据的启停标志，volatile，增强内存的可见性
    private volatile boolean flag = true;

    @Override
    public void setIn(DataIn in) {
        this.in = in;
    }

    @Override
    public void setOut(DataOut out) {
        this.out = out;
    }

    /**
     * 生产数据
     */
    @Override
    public void produce() {
        try {
            //1.读取通讯录的数据

            List<Contact> contacts = in.read(Contact.class);
            while (flag){
                //2.随机查找两个电话号码（主叫，被叫）
                int callIndex1 = new Random().nextInt(contacts.size());
                int callIndex2;
                while (true){
                    callIndex2 = new Random().nextInt(contacts.size());
                    if (callIndex1 != callIndex2){
                        break;
                    }
                }
                //随机生成的号码索引不同，主被叫不同
                Contact call1 = contacts.get(callIndex1);//主机电话号码

                Contact call2 = contacts.get(callIndex2);//被叫电话号码
                //3.生产随机的通话时间2020年全年

                String startDate = "20200101000000";
                String endDate = "20210101000000";
                //开始通话时间
                long startTime = DateUtil.parse(startDate,"yyyyMMddHHmmss").getTime();
                long endTime = DateUtil.parse(endDate,"yyyyMMddHHmmss").getTime();
                //通话时间
                long callTime = (long) (startTime + (endTime - startTime) * Math.random());
                //通话时间字符串
                String callTimeString = DateUtil.format(new Date(callTime),"yyyyMMddHHmmss");
                //4.生成随机的通话时长 duration
                //使用Java提供的指定的格式化的方法。
                String duration = NumberUtil.format(new Random().nextInt(3000),4);//最大不超过3000
//                String durationString = "" + duration;
//                保证随机生成的通话时长位数相同，便于处理。
//                int durationLength = durationString.length();
//                for (int i = 0; i < 4 - durationLength; i++) {
//                    durationString = "0" + durationString;
//                }

                //5.生成通话记录
                CallLog log = new CallLog(call1.getName(),call1.getTel(),call2.getName(),call2.getTel(),callTimeString,duration);
                System.out.println("log = " + log);
                //6.将通话记录刷写到数据文件中
                out.write(log);
                //休眠
                Thread.sleep(50);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 关闭生产者，不再产生数据
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        if (in != null){
            in.close();
        }
        if (out != null) {
            out.close();
        }
    }
}
