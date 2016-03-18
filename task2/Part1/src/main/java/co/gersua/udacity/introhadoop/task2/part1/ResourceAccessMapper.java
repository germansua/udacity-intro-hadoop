package co.gersua.udacity.introhadoop.task2.part1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResourceAccessMapper extends Mapper<Object, Text, Text, IntWritable> {

    private static Pattern pattern = Pattern.compile("[\"][\\w\\W]+[\"]");
    private static IntWritable ONE = new IntWritable(1);

    @Override
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            Text newKey = new Text(matcher.group());
            context.write(newKey, ONE);
        }
    }
}
