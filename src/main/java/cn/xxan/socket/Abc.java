package cn.xxan.socket;

import cn.xxan.reflect.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Abc {

    public static void main(String[] args){
        User zhangsan = new User("zhangsan", 123);

//        HashMap<String, String> map = new HashMap<>();
//        TreeMap<String, String> map = new TreeMap<>();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name","zhangsan");
        map.put("age","19");
        map.put("adresss","xian");

        String key = map.entrySet().iterator().next().getKey();
        String value = map.entrySet().iterator().next().getValue();
        System.out.println(key + "," + value + "测试冲突处理");

    }
}
