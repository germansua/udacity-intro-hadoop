package co.gersua.udacity.introhadoop.task2.part3;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Main {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job mostPopularPathJob = Job.getInstance(conf, "Most popular path");
        mostPopularPathJob.setJarByClass(Main.class);

        mostPopularPathJob.setMapperClass(MostPopularPathMapper.class);
        mostPopularPathJob.setReducerClass(MostPopularPathReducer.class);

        mostPopularPathJob.setMapOutputKeyClass(Text.class);
        mostPopularPathJob.setMapOutputValueClass(IntWritable.class);

        mostPopularPathJob.setOutputKeyClass(Text.class);
        mostPopularPathJob.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(mostPopularPathJob, new Path(args[0]));
        FileOutputFormat.setOutputPath(mostPopularPathJob, new Path(args[1]));

        System.exit(mostPopularPathJob.waitForCompletion(true) ? 0 : 1);
    }
}
