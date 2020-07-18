package telecom.bigdata.io;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


/**
 * @author Mr. Li xiaogao 2020-06-02 9:44
 */
public class TelecomOutputFormat extends OutputFormat<Text,Text> {

    @Override
    public RecordWriter<Text, Text> getRecordWriter(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        return new MySQLRecordWriter();
    }

    @Override
    public void checkOutputSpecs(JobContext jobContext) throws IOException, InterruptedException {

    }
    private FileOutputCommitter committer = null;
    private static Path getOutputPath(JobContext job){
        String name = job.getConfiguration().get(FileOutputFormat.OUTDIR);
        return name == null ? null:new Path(name);
    }
    @Override
    public OutputCommitter getOutputCommitter(TaskAttemptContext context) throws IOException, InterruptedException {
        if (committer == null) {
            Path output = getOutputPath(context);
            committer = new FileOutputCommitter(output,context);
        }
        return committer;
    }
}
