package cn.xxan.hadoop.mr.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WCReducer extends Reducer<Text, LongWritable, Text, LongWritable>{



	//框架在map处理完成之后，将所有kv对缓存起来，进行分组，然后传递一个组<key,valus{}>，调用一次reduce方法
	//<hello,{1,1,1,1,1,1.....}>
	@Override
	protected void reduce(Text key, Iterable<LongWritable> values,Context context)
			throws IOException, InterruptedException {
		//0代表成功，1代表失败
		int taskfalse = 0;
		long count = 0;
		try {
			count = 0;
			//遍历value的list，进行累加求和
			for(LongWritable value:values){

				count += value.get();

			}
			/*if (count == 5) {

				int i = 10/0;
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			taskfalse = 1;
		}

		//输出这一个单词的统计结果

		context.write(key, new LongWritable(count));

	}



}
