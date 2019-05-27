package cn.xxan.effective;

/**
 * 构建者模式
 */
public class Strdent {

    private String userName;
    private String password;

    private String age;
    private String money;

    public static class Builder{
        private String userName;
        private String password;

        private String age = "18";
        private String money = "100k";

        public Builder(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }

        public Builder money(String money) {
            this.money = money;
            return this;
        }

        public Strdent build(){
            return new Strdent(this);
        }
    }

    private Strdent(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.age = builder.age;
        this.money = builder.money;
    }

    public void main(String[] args){
        Strdent strdent = new Strdent.Builder("lilei", "123456").age("25").money("1000k").build();
    }
}
