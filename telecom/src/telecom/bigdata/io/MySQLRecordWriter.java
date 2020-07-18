package telecom.bigdata.io;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import telecom.web.dao.UserDao;

import java.io.IOException;

/**
 * @author Mr. Li xiaogao 2020-06-02 11:09
 */
public class MySQLRecordWriter extends RecordWriter<Text, Text> {
    @Override
    public void write(Text key, Text value) throws IOException, InterruptedException {
        //写进数据库中
        UserDao dao = new UserDao();
        dao.insertData(key,value);
    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {

    }
}
