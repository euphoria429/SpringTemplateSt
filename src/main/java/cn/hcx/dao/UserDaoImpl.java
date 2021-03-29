package cn.hcx.dao;

import cn.hcx.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Resource
//    声明JdbcTemplate属性及其setter方法
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(User user) {
//        定义SQL
        String sql="insert into user(id,name,age,sex,role) value(?,?,?,?,?)";
//        定义数组来储存SQL语句中的参数
        Object[] obj=new Object[]{user.getId(),user.getName(),user.getAge(),user.getSex(),user.getRole()};
//        执行添加操作，返回的是受SQL语句影响的记录条数
        System.out.println(obj.length);
        int num=this.jdbcTemplate.update(sql,obj);
        return num;
    }

    @Override
    public int updateUser(User user) {
        //        定义SQL
        String sql="update user set name=?,age=?,sex=?,role=? where id=?";
//        定义数组来储存SQL语句中的参数
        Object[] params=new Object[]{user.getName(),user.getAge(),user.getSex(),user.getRole(),user.getId()};
//        执行添加操作，返回的是受SQL语句影响的记录条数
        int num=this.jdbcTemplate.update(sql,params);
        return num;
    }

    @Override
    public int deleteUser(String id) {
        String sql="delete from user where id= ?";
        int num=this.jdbcTemplate.update(sql,id);
        return num;
    }

    @Override
    public User findUserById(String id) {
        String sql="select * from user where id =?";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public List<User> findUserByName(String name) {
        String sql="select * from user where name =\'"+name+"\'";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<User> findUserByAgeAndSex(int age, String sex) {
        String sql="select * from user where sex =\'"+sex+"\' and age="+age;
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.query(sql,rowMapper);
    }
}
