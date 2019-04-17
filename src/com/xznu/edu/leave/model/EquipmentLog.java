package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="t_equipmentlog")
public class EquipmentLog implements Serializable {

    private Integer id;
    //是否借用（0未借用 1借用）
    private Integer isYy;
    //借用人
    private User user;
    //借用时间
    private Date time;
    //结束借用时间
    private Date endTime;
    //借用归还人
    private User qx;

    private Equipment equipment;
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="qx_id")
    public User getQx() {
        return qx;
    }

    public void setQx(User qx) {
        this.qx = qx;
    }
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="Equipment_id")
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
