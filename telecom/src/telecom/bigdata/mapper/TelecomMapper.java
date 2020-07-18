package telecom.bigdata.mapper;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Mr. Li xiaogao 2020-06-02 6:50
 */
public class TelecomMapper extends Mapper<LongWritable, Text,Text,Text> {
    //主叫用户
    String user1;
    String call1;
    //被叫用户
    String user2;
    String call2;
    //通话时间
    String callTime;
    //通话时长
    String duration;
    //某用户年通话信息，打了多少次电话，总共的通话时长
    String year;
    //月通话信息，一个月内打了多少次电话，总共通话时长
    String month;
    //日通话信息
    String day;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //华贞	16160892861	焦秋菊	15280214634	20201121170735	1785
        String line = value.toString();
        String[] fields = line.split("\t");
        user1 = fields[0];
        call1 = fields[1];
        user2 = fields[2];
        call2 = fields[3];
        callTime = fields[4];
        duration = fields[5];

        year = callTime.substring(0,4);
        month = callTime.substring(0,6);
        day = callTime.substring(0,8);

        //主叫用户-年通话次数-通话时长
        context.write(new Text("0_" + user1 + "_" + call1 + "_" + year),new Text(duration));
        //主叫用户-月通话次数-通话时长
        context.write(new Text("0_" + user1 + "_" + call1 + "_" + month),new Text(duration));
        //主叫用户-日通话次数-通话时长
        //context.write(new Text("0_" + user1 + "_" + call1 + "_" + day),new Text(duration));

        //被叫用户-年通话次数-通话时长
        context.write(new Text("1_" + user2 + "_" + call2 + "_" + year),new Text(duration));
        //被叫用户-月通话次数-通话时长
        context.write(new Text("1_" + user2 + "_" + call2 + "_" + month),new Text(duration));
        //被叫用户-日通话次数-通话时长
        //context.write(new Text("1_" + user2 + "_" + call2 + "_" + day),new Text(duration));

    }
}
