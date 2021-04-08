package cn.hcx.bean;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private Long id;

//    private String username; //用户名

    private String operation; //操作

    private String method; //方法名

    private String params; //参数

//    private String ip; //ip地址

    private Date createDate; //操作时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}