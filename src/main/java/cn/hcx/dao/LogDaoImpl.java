package cn.hcx.dao;

import cn.hcx.bean.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("logDao")
public class LogDaoImpl implements LogDao {

    @Resource
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    @Override
    public int addLog(Log log) {
        String sql="insert into log(id,operation,method,params,createDate) value(?,?,?,?,?)";
        Object[] obj=new Object[]{log.getId(),log.getOperation(),log.getMethod(),log.getParams(),log.getCreateDate()};
        int num=this.jdbcTemplate.update(sql,obj);
        if (num>0){
            System.out.println("成功保存日志！");
        }else {
            System.out.println("日志写入失败！");
        }
        return num;
    }
}
