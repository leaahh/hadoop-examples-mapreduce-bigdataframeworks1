package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class MaxHeightPerKindMapper extends Mapper<Object, Text, Text, FloatWritable>{
    public int line = 0;

    public void map(Object key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        if (line != 0) {
            try{
                Float height = Float.parseFloat(value.toString().split(";")[6]);
                context.write(new Text(value.toString().split(";")[2]), new FloatWritable(height));
            } catch(NumberFormatException e) {}
        }line++;
    }
}
