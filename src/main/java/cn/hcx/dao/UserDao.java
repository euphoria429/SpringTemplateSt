package cn.hcx.dao;

import cn.hcx.bean.User;

import java.util.List;

public interface UserDao {
//    添加
    public int addUser(User user);
//    修改
    public int updateUser(User user);
//    删除
    public int deleteUser(String id);

    public User findUserById(String id);

    public List<User> findUserByName(String name);

    public List<User> findUserByAgeAndSex(int age,String sex);
}
