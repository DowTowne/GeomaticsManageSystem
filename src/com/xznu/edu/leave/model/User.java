package com.xznu.edu.leave.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="t_user")
public class User implements Serializable {

    private Integer id;
    //用户名
    private String name;
    //号码
    private String number;
    //手机号码
    private String phone;
    //学院
    private String xy;
    //班级
    private String bj;
    //密码
    private String pass;
    //真实姓名
    private String realName;
    //0未删除，1已删除
    private Integer isDelete;
    //是否审核（0未审核 1审核）
    private Integer isSh;
    //角色
    private Role role;
    private Date time;
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Column(name="isDelete", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name="isSh", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsSh() {
        return isSh;
    }

    public void setIsSh(Integer isSh) {
        this.isSh = isSh;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
