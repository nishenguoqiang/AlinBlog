package cn.xxan.hadoop.alin.test;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.*;
import java.sql.*;
import java.util.Arrays;

public class RdLinkPidMR {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        File file = new File("D:/test/node/123");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write("453221");
        writer.write(" ");
        writer.write("453223");
        writer.write(" ");
        writer.write("453225");
        writer.write("\r");
        writer.write("453228");
        writer.write(" ");
        writer.write("453229");
        writer.flush();
        writer.close();

        Configuration conf = new Configuration();
        conf.set("ip","192.168.3.67");
        conf.set("port","1521");
        conf.set("schema","nirobot_280_shenguoqiang");
        conf.set("password","nirobot_280_shenguoqiang");

        Job job = Job.getInstance(conf, "oracleMR");
        job.setJarByClass(RdLinkPidMR.class);
        job.setMapperClass(RdLinkPidMapper.class);
        job.setReducerClass(RdLinkPidReducer.class);

        //指定reduce的输出数据kv类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        //指定mapper的输出数据kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        String inputFile = "D:/test/node";
        FileInputFormat.setInputPaths(job,new Path(inputFile));
        String outputFile = "D:/test/node/out";
        FileOutputFormat.setOutputPath(job,new Path(outputFile));

        job.waitForCompletion(true);

    }


}
