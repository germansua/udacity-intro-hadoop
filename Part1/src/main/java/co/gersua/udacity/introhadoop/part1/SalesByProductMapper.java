package co.gersua.udacity.introhadoop.part1;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SalesByProductMapper extends Mapper<Object, Text, Text, DoubleWritable> {
    
    @Override
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] splitLine = line.split("\t");

        if (splitLine.length != 6) {
            return;
        }

        String product = splitLine[3];
        double amount = Double.parseDouble(splitLine[4]);

        Text productKey = new Text(product);
        DoubleWritable amountValue = new DoubleWritable(amount);

        context.write(productKey, amountValue);
    }
}
