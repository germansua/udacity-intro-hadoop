package co.gersua.udacity.introhadoop.part31;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TotalSalesAndCountMapper extends Mapper<Object, Text, Text, DoubleWritable> {

    private static final int COUNT = 1;

    @Override
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] splitLine = line.split("\t");

        if (splitLine.length != 6) {
            return;
        }

        Text textKey = new Text("Sales");
        DoubleWritable salesValue = new DoubleWritable(Double.parseDouble(splitLine[4]));
        context.write(textKey, salesValue);
    }
}
