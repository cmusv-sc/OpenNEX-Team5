import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MetaTransform {
	public static HashSet<String> dictionary;
	
	public static class Map extends Mapper<Object, Text, Text, Text> {
		private Text wordText = new Text();
		private Text idText = new Text();
		
		HashSet<String> stopwords = new HashSet<String>();
		
		protected void setup (Context context) throws IOException,InterruptedException {
			Configuration conf = context.getConfiguration();
			URI[] cachefile = DistributedCache.getCacheFiles(conf);
			FSDataInputStream in =FileSystem.get(conf).open(new Path(cachefile[0].getPath()));
			BufferedReader bufreader = new BufferedReader(new InputStreamReader(in));
			String line1;
			try{
			while ((line1= bufreader.readLine())!=null) {
				stopwords.add(line1.toLowerCase().trim());
			}
			} finally {
				bufreader.close();
			}
		}
		@Override
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] linetoken = line.split(",");
			String id = linetoken[1];
			// description is all strings starting from item 5
			StringBuilder buffer = new StringBuilder();
			for(int i=5; i < linetoken.length; i++){
				buffer.append(linetoken[i]);
			}
			String description = buffer.toString();
			StringTokenizer describetoken = new StringTokenizer(description.replaceAll("\\p{P}", "").toLowerCase(), " ");
			idText.set(id);
			while (describetoken.hasMoreTokens()) {
				String token = describetoken.nextToken();
				token = token.toLowerCase().trim();
				if(!stopwords.contains(token)) {
					wordText.set(token);
					context.write(idText, wordText);
				}
			}
			
		}
	}
	public static class Reduce extends Reducer<Text, Text, Text, Text> {
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			HashSet<String> hashset = new HashSet<String>();
			for (Text value : values) {
				String s = value.toString();
				if(!s.equalsIgnoreCase("a")){ // for some reason, a rogue 'a' gets into the mix, lets remove it
					
					hashset.add(s);	
				}
			}
			StringBuilder buffer = new StringBuilder();
			for(String tag : hashset){
				buffer.append(tag).append(";");
			}
			String tags = buffer.toString();
			if(tags.length() > 0){
				tags = tags.substring(0, tags.length()-1);
			}
			context.write(new Text(key + ","), new Text(tags));
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Configuration conf = new Configuration();
		
		Job job = new Job(conf, "metatransform");
		job.setJarByClass(MetaTransform.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		
//		job.setInputFormatClass(TextInputFormat.class);
//		job.setOutputFormatClass(TextOutputFormat.class);

		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		DistributedCache.addCacheFile(new URI("hdfs:///bonus/stopwords.txt"), job.getConfiguration());
		
		job.waitForCompletion(true);

	}

}
