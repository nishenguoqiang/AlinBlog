package cn.xxan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

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
}
