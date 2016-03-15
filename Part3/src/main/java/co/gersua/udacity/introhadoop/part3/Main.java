package co.gersua.udacity.introhadoop.part3;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Main {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job totalSalesNumberJob = Job.getInstance(conf, "Total sales value across all the stores, and the total number of sales");
        totalSalesNumberJob.setJarByClass(Main.class);

        totalSalesNumberJob.setMapperClass(TotalSalesAndNumberOfSalesMapper.class);
        totalSalesNumberJob.setReducerClass(TotalSalesAndNumberOfSalesReducer.class);

        totalSalesNumberJob.setMapOutputKeyClass(Text.class);
        totalSalesNumberJob.setMapOutputValueClass(DoubleWritable.class);

        totalSalesNumberJob.setOutputKeyClass(Text.class);
        totalSalesNumberJob.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(totalSalesNumberJob, new Path(args[0]));
        FileOutputFormat.setOutputPath(totalSalesNumberJob, new Path(args[1]));

        System.exit(totalSalesNumberJob.waitForCompletion(true) ? 0 : 1);
    }
}
