package cn.hcx.bean;

public class User {
    private String id;
    private String name;
    private int age;
    private String sex;
    private String role;

    public User() {
    }

    public User(String id, String name, int age, String sex, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
