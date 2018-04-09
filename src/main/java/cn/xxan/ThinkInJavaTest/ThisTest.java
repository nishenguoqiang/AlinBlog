package cn.xxan.ThinkInJavaTest;

/**
 * @ClassName: ThisTest
 * @Author alin
 * @Date 2018/4/9 9:22
 * @Description: 测试this关键字
 */
public class ThisTest {
    String s = "abc";

    public void testThis(){
        System.out.println(s);
        ThisServer thisServer = new ThisServer();
        thisServer.init(this);//this传递的是当前对象的引用
        System.out.println(s);
    }

    public static void main(String[] args){
        ThisTest thisTest = new ThisTest();
        thisTest.testThis();
    }
}
