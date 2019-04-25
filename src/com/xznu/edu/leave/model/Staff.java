package com.xznu.edu.leave.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_staff")
public class Staff implements Serializable {

    private Integer id;
    //姓名
    private String name;    
    //手机号码
    private String phone;
    //身份证号
    private String ID_number;
    //测区
    private SurveyingZone surveyingZone;
    //角色ID对应的字符串，以逗号分隔	
    private String rolesID;
    //工作状态
    private StaffStatus staffStatus;
    //密码
    private String pass;
    //0未删除，1已删除
    private Integer isDelete;
    //是否审核（0未审核 1审核）
    private Integer isSh;
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
      
    //roles_id
    public String getRolesID() {
        return rolesID;
    }

    public void setRolesID(String rolesID) {
        this.rolesID = rolesID;
    }   

    public String getID_number() {
        return ID_number;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="staff_status_id")
    public StaffStatus getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(StaffStatus staffStatus) {
        this.staffStatus = staffStatus;
    }   
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="surveying_zone_id")
    public SurveyingZone getSurveyingZone() {
        return surveyingZone;
    }

    public void setSurveyingZone(SurveyingZone surveyingZone) {
        this.surveyingZone = surveyingZone;
    }   
    
    //isDelete
    @Column(name="isDelete", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    
    //isSh
    @Column(name="isSh", nullable=false, columnDefinition="int default 0", updatable = true, insertable = false)
    public Integer getIsSh() {
        return isSh;
    }

    public void setIsSh(Integer isSh) {
        this.isSh = isSh;
    }

}
