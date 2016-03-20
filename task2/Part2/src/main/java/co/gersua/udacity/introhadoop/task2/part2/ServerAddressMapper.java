package co.gersua.udacity.introhadoop.task2.part2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerAddressMapper extends Mapper<Object, Text, Text, IntWritable> {

    private static final Pattern pattern = Pattern.compile("[0-9]{1,3}[\\.][0-9]{1,3}[\\.][0-9]{1,3}[\\.][0-9]{1,3}");

    @Override
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            Text serverAddress = new Text(matcher.group());
            context.write(serverAddress, new IntWritable(1));
        }
    }
}
