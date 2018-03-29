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
        System.out.println(key + "," + value);
        System.out.println("通过git stash 保存的内容");
        System.out.println("未提交的冲突解决");
        System.out.println("这是本地改了的");

    }
}
