package cn.hcx.bean;

public class Account {
    private String userId;
    private int money;

    public Account() {
    }

    public Account(String userId, int money) {
        this.userId = userId;
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId='" + userId + '\'' +
                ", money=" + money +
                '}';
    }
}
