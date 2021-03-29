package cn.hcx.test;

import cn.hcx.bean.User;
import cn.hcx.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppTest {
    @Test
    public  void TestJdbc(){
        System.out.println("ke");
    }
    @Test
    public void addUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=(UserDao)applicationContext.getBean("userDao");
        User user=new User();
        user.setId("C1");
        user.setName("jidu");
        user.setAge(20);
        user.setSex("male");
        user.setRole("C");
        System.out.println(user.toString());
        int num=userDao.addUser(user);
        if (num>0){
            System.out.println("成功插入了"+num+"条数据！");
        }else {
            System.out.println("插入操作执行失败！");
        }
    }

    @Test
    public void TestUpdate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=(UserDao)applicationContext.getBean("userDao");
        User user=new User();
        user.setId("C1");
        user.setName("tjlj");
        user.setAge(19);
        user.setSex("female");
        user.setRole("C2");
        System.out.println(user.toString());
        int num=userDao.updateUser(user);
        System.out.println(num);
        if (num>0){
            System.out.println("成功修改了"+num+"条数据！");
        }else {
            System.out.println("修改操作执行失败！");
        }
    }

    @Test
    public void TestDelete(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=(UserDao)applicationContext.getBean("userDao");
        int num=userDao.deleteUser("C1");
        if (num>0){
            System.out.println("成功删除了"+num+"条数据！");
        }else {
            System.out.println("删除操作执行失败！");
        }
    }

    @Test
    public  void TestFindById(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=(UserDao)applicationContext.getBean("userDao");
        System.out.println("查询id为A1的数据");
        User user=userDao.findUserById("A1");
        System.out.println(user);
    }

    @Test
    public  void TestFindAllByName(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=(UserDao)applicationContext.getBean("userDao");
        System.out.println("查询name为aomj的数据");
        List<User> user=userDao.findUserByName("aomj");
        for (User act : user){
            System.out.println(act);
        }
    }

    @Test
    public void TestFindByAgeAndSex(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=(UserDao)applicationContext.getBean("userDao");
        System.out.println("查询age为18,sex为female的数据");
        List<User> user=userDao.findUserByAgeAndSex(18,"female");
        for (User act : user){
            System.out.println(act);
        }
    }
}

