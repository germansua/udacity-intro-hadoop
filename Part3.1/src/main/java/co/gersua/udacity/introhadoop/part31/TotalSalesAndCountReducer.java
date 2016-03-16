package co.gersua.udacity.introhadoop.part31;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TotalSalesAndCountReducer extends Reducer<Text, DoubleWritable, Text, Text> {

    @Override
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {

        double totalSales = 0.0;
        int totalCount = 0;

        for (DoubleWritable value : values) {
            totalSales += value.get();
            totalCount++;
        }

        Text outputValue = new Text(String.format("Total Sales: %.2f, Total Count: %d", totalSales, totalCount));
        context.write(key, outputValue);
    }
}
