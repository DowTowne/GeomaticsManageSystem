package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="type_of_equipment_status")
public class EquipmentStatus implements Serializable {

    private Integer id;
    //状态名称
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
    
    @Column(name="isDelete", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
