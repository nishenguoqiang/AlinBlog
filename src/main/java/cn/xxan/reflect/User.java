package cn.xxan.reflect;

import java.util.Random;

public class User {
    private int num;
    private String name;
    private int age;
    private String wife;
    private UserInfo userInfo;

    public User(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public User(String name, int age) {
        Random random = new Random();
        this.num = random.nextInt();
        this.name = name;
        this.age = age;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
