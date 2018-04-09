package cn.xxan.hadoop.alin.test;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.sql.*;

public class RdLinkPidMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    String ip = null;
    String schema = null;
    String password = null;
    Connection conn = null;
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        ip = context.getConfiguration().get("ip");
        schema = context.getConfiguration().get("schema");
        password = context.getConfiguration().get("password");
        String url = "jdbc:oracle:thin:@" + ip + ":1521:orcl";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,schema,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] pids = value.toString().split(" ");
        String sql = "select s_node_pid from rd_link where link_pid = ? ";
        try {
            PreparedStatement ppst = conn.prepareStatement(sql);
            for (String pid:pids){
                ppst.setString(1,pid);
                ResultSet resultSet = ppst.executeQuery();
                if (resultSet.next()){
                    String s_node_pid = resultSet.getString(1);
                    context.write(new Text(pid),new LongWritable(Integer.parseInt(s_node_pid)));

                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        super.cleanup(context);
    }

    @Override
    public void run(Context context) throws IOException, InterruptedException {
        super.run(context);
    }
}
