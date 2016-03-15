package co.gersua.udacity.introhadoop.part2;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class HighestIndividualSaleForStoreReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

    @Override
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {

        double maxValue = 0;
        for (DoubleWritable value : values) {
            double currentValue = value.get();

            if (maxValue < currentValue) {
                maxValue = currentValue;
            }
        }

        context.write(key, new DoubleWritable(maxValue));
    }
}
