package co.gersua.udacity.introhadoop.part31;

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

        Job totalSalesCount = Job.getInstance(conf, "Total sales value across all the stores, and the total number of sales.");
        totalSalesCount.setJarByClass(Main.class);

        totalSalesCount.setMapperClass(TotalSalesAndCountMapper.class);
        totalSalesCount.setReducerClass(TotalSalesAndCountReducer.class);

        totalSalesCount.setMapOutputKeyClass(Text.class);
        totalSalesCount.setMapOutputValueClass(DoubleWritable.class);

        totalSalesCount.setOutputKeyClass(Text.class);
        totalSalesCount.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(totalSalesCount, new Path(args[0]));
        FileOutputFormat.setOutputPath(totalSalesCount, new Path(args[1]));

        System.exit(totalSalesCount.waitForCompletion(true) ? 0 : 1);
    }
}
