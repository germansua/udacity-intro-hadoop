package co.gersua.udacity.introhadoop.part3;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TotalSalesAndNumberOfSalesMapper extends Mapper<Object, Text, Text, DoubleWritable> {

    @Override
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] splitLine = line.split("\t");

        if (splitLine.length != 6) {
            return;
        }

        String store = splitLine[2];
        double sales = Double.parseDouble(splitLine[4]);

        Text storeKey = new Text(store);
        DoubleWritable salesValue = new DoubleWritable(sales);

        context.write(storeKey, salesValue);
    }
}
