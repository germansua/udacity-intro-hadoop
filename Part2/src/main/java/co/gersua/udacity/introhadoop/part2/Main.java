package co.gersua.udacity.introhadoop.part2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();

        Job highestValue = Job.getInstance(conf, "monetary value for the highest individual sale for each separate store");
        highestValue.setJarByClass(Main.class);

        highestValue.setMapperClass(HighestIndividualSaleForStoreMapper.class);
        highestValue.setReducerClass(HighestIndividualSaleForStoreReducer.class);

        highestValue.setMapOutputKeyClass(Text.class);
        highestValue.setMapOutputValueClass(DoubleWritable.class);

        highestValue.setOutputKeyClass(Text.class);
        highestValue.setOutputValueClass(DoubleWritable.class);

        FileInputFormat.addInputPath(highestValue, new Path(args[0]));
        FileOutputFormat.setOutputPath(highestValue, new Path(args[1]));

        System.exit(highestValue.waitForCompletion(true) ? 0 : 1);
    }
}
