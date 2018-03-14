package cn.xxan.reflect;

public class Man extends User{
    private String female = "man";

    public Man(UserInfo userInfo) {
        super(userInfo);
    }

    public Man(String name, int age) {
        super(name, age);
        System.out.println("我是man。");
    }
}
