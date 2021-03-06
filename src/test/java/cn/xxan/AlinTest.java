package cn.xxan;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.*;
import java.util.*;

public class AlinTest {

    /**
     * 对迭代器iterator使用增强for循环
     */
    @Test
    public void testForeach(){
        ArrayList<String> strArr = new ArrayList<>();
        strArr.add("zhangsan");
        strArr.add("lisi");
        strArr.add("wangwu");
        strArr.add("abc");
        for (Iterator<String> iterator = strArr.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void saveNum() throws Exception{
        String driver = "oracle.jdbc.OracleDriver";    //驱动标识符
        String url ="jdbc:oracle:thin:@192.168.3.67:1521:orcl";  // 连接远程的数据库可以这么写
        String user = "nirobot_280_shenguoqiang";         //数据库的用户名
        String password = "nirobot_280_shenguoqiang";     //数据库的密码
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean flag = false;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String sql = "insert into rd_link_temp select * from rd_link";
            String sql0 = "insert into update_date values(sysdate)";
            QueryRunner runner = new QueryRunner();
            con.setAutoCommit(false);
            runner.update(con,sql);
//            int abc = 10/0;
            con.commit();
            runner.update(con,sql0);
            con.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void assembleSql(){
        String sql = "SELECT I.PID,I.KIND_CODE,I.POI_NUM FROM IX_POI I "
                + "WHERE I.POI_NUM IN (";

        List<String> parms = new LinkedList<>();
        for (int i = 0;i<=9483648;i++){
            parms.add("123456" + i);
        }



        String sqlStr = getSqlStr(parms, "I.POI_NUM");
        System.out.println(sqlStr);
        sql+=sqlStr;
        System.out.println(sql);
    }
    //拼接sql，避免in中的参数超过1000个
    public static String getSqlStr(List list, String parameter) {
        if (!list.isEmpty()) {
            List<String> setList = new ArrayList<String>(0);
            Set set = new HashSet();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 1; i <= list.size(); i++) {
                set.add("'" + list.get(i - 1) + "'");
                if (i % 9 == 0) {//999为阈值
                    setList.add(org.apache.commons.lang.StringUtils.join(set.iterator(), ","));
                    set.clear();
                }
            }
            if (!set.isEmpty()) {
                setList.add(org.apache.commons.lang.StringUtils.join(set.iterator(), ","));
            }
            stringBuffer.append(setList.get(0));
            for (int j = 1; j < setList.size(); j++) {
                stringBuffer.append(") or " + parameter + " in (");
                stringBuffer.append(setList.get(j));
            }
            return stringBuffer.toString() + ")";
        } else {
            return "'')";
        }

    }
}
