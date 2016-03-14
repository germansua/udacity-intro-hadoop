package co.gersua.udacity.introhadoop.part1;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SalesByProductMapper extends Mapper<Object, Text, Text, DoubleWritable> {
    
    @Override
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
    }
}
