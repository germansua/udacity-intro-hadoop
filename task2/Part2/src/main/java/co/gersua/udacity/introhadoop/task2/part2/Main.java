package co.gersua.udacity.introhadoop.task2.part2;

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

        Job serverAddressJob = Job.getInstance(conf, "Server Addresses Count");
        serverAddressJob.setJarByClass(Main.class);

        serverAddressJob.setMapperClass(ServerAddressMapper.class);
        serverAddressJob.setReducerClass(ServerAddressReducer.class);

        serverAddressJob.setMapOutputKeyClass(Text.class);
        serverAddressJob.setMapOutputValueClass(IntWritable.class);

        serverAddressJob.setOutputKeyClass(Text.class);
        serverAddressJob.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(serverAddressJob, new Path(args[0]));
        FileOutputFormat.setOutputPath(serverAddressJob, new Path(args[1]));

        System.exit(serverAddressJob.waitForCompletion(true) ? 0 : 1);
    }
}
