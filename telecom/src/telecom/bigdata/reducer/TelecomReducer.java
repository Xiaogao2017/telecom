package telecom.bigdata.reducer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author Mr. Li xiaogao 2020-06-02 9:42
 */
public class TelecomReducer extends Reducer<Text,Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //通话总次数
        int sumCall = 0;
        //通话总时长
        int sumDuration = 0;
        for (Text value : values) {
            int duration = Integer.parseInt(value.toString());
            sumDuration = sumDuration + duration;
            sumCall++;
        }
        context.write(key,new Text(sumCall + "_" + sumDuration));
    }
}
