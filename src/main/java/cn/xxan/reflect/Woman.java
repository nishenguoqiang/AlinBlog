package cn.xxan.reflect;

public class Woman extends User{
    private String female = "woman";

    public Woman(UserInfo userInfo) {
        super(userInfo);
    }

    public Woman(String name, int age) {
        super(name, age);
        System.out.println("我是woman。");
    }
}
