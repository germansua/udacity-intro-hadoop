package co.gersua.udacity.introhadoop.task2.part1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ResourceAccessMapper extends Mapper<Object, Text, Text, IntWritable> {

    @Override
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
    }
}
