package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="type_of_staff_status")
public class StaffStatus implements Serializable {

    private Integer id;
    //工作状态，1是在职，2是离职
    private String name;
    //0未删除，1已删除
    private Integer isDelete;
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }   
    
    //name
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }    
    
    //isDelete
    @Column(name="isDelete", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    
}
