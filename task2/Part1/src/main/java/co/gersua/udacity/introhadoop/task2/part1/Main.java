package co.gersua.udacity.introhadoop.task2.part1;

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

        Job pagesCountJob = Job.getInstance(conf, "Number of pages count");
        pagesCountJob.setJarByClass(Main.class);

        pagesCountJob.setMapperClass(ResourceAccessMapper.class);
        pagesCountJob.setReducerClass(ResourceAccessReducer.class);

        pagesCountJob.setMapOutputKeyClass(Text.class);
        pagesCountJob.setMapOutputValueClass(IntWritable.class);

        pagesCountJob.setOutputKeyClass(Text.class);
        pagesCountJob.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(pagesCountJob, new Path(args[0]));
        FileOutputFormat.setOutputPath(pagesCountJob, new Path(args[1]));

        System.exit(pagesCountJob.waitForCompletion(true) ? 0 : 1);
    }
}
