package co.gersua.udacity.introhadoop.part1;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SalesByProductReducer extends Reducer<Text, DoubleWritable, Text, Text> {
    
    @Override
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context) 
            throws IOException, InterruptedException {

        BigDecimal total = BigDecimal.ZERO;
        for (DoubleWritable value : values) {
            total = total.add(new BigDecimal(value.get()));
        }

        context.write(key, new Text(total.toString()));
    }
}
