package co.gersua.udacity.introhadoop.part1;

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

        Job salesByProduct = Job.getInstance(conf, "Sales breakdown by product category across all of our stores");
        salesByProduct.setJarByClass(Main.class);

        salesByProduct.setMapperClass(SalesByProductMapper.class);
        salesByProduct.setReducerClass(SalesByProductReducer.class);

        salesByProduct.setMapOutputKeyClass(Text.class);
        salesByProduct.setMapOutputValueClass(DoubleWritable.class);

        salesByProduct.setOutputKeyClass(Text.class);
        salesByProduct.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(salesByProduct, new Path(args[0]));
        FileOutputFormat.setOutputPath(salesByProduct, new Path(args[1]));

        System.exit(salesByProduct.waitForCompletion(true) ? 0 : 1);
    }
}
