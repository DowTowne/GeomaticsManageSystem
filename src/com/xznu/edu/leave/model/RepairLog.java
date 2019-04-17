package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="t_RepairLog")
public class RepairLog implements Serializable {

    private Integer id;
    //标题
    private String title;
    //原因
    private String bz;

    //0未删除，1已删除
    private Integer isDelete;
    //保修时间
    private Date bxTime;
    //结束时间
    private Date endTime;
    //设备位置
    private String wz;
    private Equipment equipment;
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

    public Date getBxTime() {
        return bxTime;
    }

    public void setBxTime(Date bxTime) {
        this.bxTime = bxTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="Equipment_id")
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getWz() {
        return wz;
    }

    public void setWz(String wz) {
        this.wz = wz;
    }
}
