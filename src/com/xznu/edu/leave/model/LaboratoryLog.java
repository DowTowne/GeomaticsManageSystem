package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="t_LaboratoryLog")
public class LaboratoryLog implements Serializable {

    private Integer id;
    //是否预约（0未预约 1预约）
    private Integer isYy;
    //预约人
    private User user;
    //预约时间
    private Date time;
    //结束预约时间
    private Date endTime;
    //结束预约操作人
    private User qx;
    private Laboratory laboratory;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="laboratory_id")
    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="userQx_id")
    public User getQx() {
        return qx;
    }

    public void setQx(User qx) {
        this.qx = qx;
    }

}
