package co.gersua.udacity.introhadoop.task2.part2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ServerAddressReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {

        int countByKey = 0;
        for (IntWritable value : values) {
            countByKey++;
        }

        context.write(key, new IntWritable(countByKey));
    }
}
