package telecom.bigdata.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import telecom.bigdata.io.TelecomOutputFormat;
import telecom.bigdata.mapper.TelecomMapper;
import telecom.bigdata.reducer.TelecomReducer;

import java.io.IOException;

/**
 * @author Mr. Li xiaogao 2020-06-02 9:40
 */
public class TelecomDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 1 获取配置信息，或者job对象实例
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        // 2 指定本程序的jar包所在的本地路径
        job.setJarByClass(TelecomDriver.class);
        // 3 指定本业务job要使用的Mapper/Reducer业务类
        job.setMapperClass(TelecomMapper.class);
        job.setReducerClass(TelecomReducer.class);
        // 4 指定Mapper输出数据的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        // 5 指定最终输出的数据的kv类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setOutputFormatClass(TelecomOutputFormat.class);
        // 6 指定job的输入原始文件所在目录
        FileInputFormat.setInputPaths(job, new Path("d:/hadoopDemo/input18"));
        //FileOutputFormat.setOutputPath(job, new Path("d:/hadoopDemo/output18"));
        // 7 将job中配置的相关参数，以及job所用的java类所在的jar包， 提交给yarn去运行
        boolean result = job.waitForCompletion(true);
        System.out.println("result = " + result);
    }
}
