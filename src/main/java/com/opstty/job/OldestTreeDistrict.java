package com.opstty.job;

import com.opstty.mapper.MaxHeightPerKindMapper;
import com.opstty.mapper.OldestTreeDistrictMapper;
import com.opstty.reducer.MaxHeightPerKindReducer;
import com.opstty.reducer.OldestTreeDistrictReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class OldestTreeDistrict {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: Oldest Tree of each district <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "OldestTreeDistrict");
        job.setJarByClass(OldestTreeDistrict.class);
        job.setMapperClass(OldestTreeDistrictMapper.class);
        job.setCombinerClass(OldestTreeDistrictReducer.class);
        job.setReducerClass(OldestTreeDistrictReducer.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
