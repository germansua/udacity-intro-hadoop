package co.gersua.udacity.introhadoop.task2.part3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MostPopularPathMapper extends Mapper<Object, Text, Text, IntWritable> {

    private static final Pattern PATTERN = Pattern.compile("([/][\\w\\-]+)+/[\\w-]+\\.[\\w0-9]{2,6}");

    @Override
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            Text path = new Text(matcher.group());
            context.write(path, new IntWritable(1));
        }
    }
}
