package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="t_Laboratory")
public class Laboratory implements Serializable {

    private Integer id;
    //实验室名称
    private String name;
    //负责人
    private String fzr;
    //负责人电话
    private String fzrDh;
    //具体地点
    private String address;
    //实验室备注
    private String bz;
    //0未删除，1已删除
    private Integer isDelete;
    //是否审核（0未预约 1预约）
    private Integer isYy;
    //预约人
    private User user;
    //预约时间
    private Date time;
    private Integer laboratoryLogId;
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    @Column(name="isDelete", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
    @Column(name="isYy", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsYy() {
        return isYy;
    }

    public void setIsYy(Integer isYy) {
        this.isYy = isYy;
    }
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getFzrDh() {
        return fzrDh;
    }

    public void setFzrDh(String fzrDh) {
        this.fzrDh = fzrDh;
    }

    public Integer getLaboratoryLogId() {
        return laboratoryLogId;
    }

    public void setLaboratoryLogId(Integer laboratoryLogId) {
        this.laboratoryLogId = laboratoryLogId;
    }
}
