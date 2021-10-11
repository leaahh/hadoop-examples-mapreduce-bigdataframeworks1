package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class OldestTreeDistrictMapper extends Mapper<Object, Text, IntWritable, IntWritable>{
    public int line = 0;

    public void map(Object key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        if (line != 0) {
            try{
                Integer plantation_year = Integer.parseInt(value.toString().split(";")[5]);
                Integer district = Integer.parseInt(value.toString().split(";")[1]);
                context.write(new IntWritable(plantation_year), new IntWritable(district));
            } catch(NumberFormatException e) {}
        }line++;
    }
}
