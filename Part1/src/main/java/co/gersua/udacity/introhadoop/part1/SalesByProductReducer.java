package co.gersua.udacity.introhadoop.part1;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SalesByProductReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    
    @Override
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context) 
            throws IOException, InterruptedException {
    }
}
