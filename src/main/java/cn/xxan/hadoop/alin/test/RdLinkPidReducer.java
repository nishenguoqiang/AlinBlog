package cn.xxan.hadoop.alin.test;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class RdLinkPidReducer extends Reducer< Text,LongWritable, Text, LongWritable>{
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        for (LongWritable value:values){
            System.out.println(value.toString());
            context.write(key,value);
         }


    }
}
