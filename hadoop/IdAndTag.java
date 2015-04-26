import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class IdAndTag {
	public static class Map extends Mapper<Object, Text, Text, Text> {
		private Text tagsText = new Text();
		private Text idText = new Text();
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] linetoken = line.split("\t");
			String id = linetoken[0];
			String tags = linetoken[1];
			StringTokenizer tagstoken = new StringTokenizer(tags.toLowerCase(), ",");
			idText.set(id);
			while (tagstoken.hasMoreTokens()) {
				tagsText.set(tagstoken.nextToken());
				context.write(tagsText, idText);
			}
			
		}
	}
	public static class Reduce extends Reducer<Text, Text, Text, Text> {
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			StringBuffer buffer = new StringBuffer();
			HashSet<String> hashset = new HashSet<String>();
			for (Text value : values) {
				String s = value.toString();
				hashset.add(s);
			}
			for (String hash : hashset) {
				buffer.append(" " + hash.toLowerCase());
			}
			context.write(new Text(key + " :"), new Text(buffer.toString()));
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		
		Job job = new Job(conf, "idandtag");
		job.setJarByClass(IdAndTag.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		
//		job.setInputFormatClass(TextInputFormat.class);
//		job.setOutputFormatClass(TextOutputFormat.class);

		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);

	}

}

