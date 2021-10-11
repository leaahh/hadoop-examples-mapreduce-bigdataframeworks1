package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class OldestTreeDistrictReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
    public int counter = 0;
    public void reduce(IntWritable year, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        while (counter==0){
            for (IntWritable district : values) {
                context.write(district,year);
            } counter++;
        }
    }
}