package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;

//测区是个空间的概念
@Entity
@Table(name="t_surveying_zone")
public class SurveyingZone implements Serializable {

    private Integer id;
    //测区名称
    private String name;
    //负责人
    private Staff director;
    //副负责人
    private Staff viceDirector;
    //具体地点
    private String address;
    //备注
    private String bz;
    //0未删除，1已删除
    private Integer isDelete;
    //分管队长
    private Staff chargedCaptain;
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

    //director
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="director_id")
    public Staff getDirector() {
        return director;
    }

    public void setDirector(Staff director) {
        this.director = director;
    }
    
    //viceDirector
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="vice_director_id")    
    public Staff getViceDirector() {
        return viceDirector;
    }

    public void setViceDirector(Staff viceDirector) {
        this.viceDirector = viceDirector;
    }
    
    //chargedCaptain
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="charged_captain_id")    
    public Staff getChargedCaptain() {
        return chargedCaptain;
    }

    public void setChargedCaptain(Staff chargedCaptain) {
        this.chargedCaptain = chargedCaptain;
    }

    //测区地址
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

}
