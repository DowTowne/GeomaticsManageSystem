package com.xznu.edu.leave.action;

/**
 * 用户新增
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.*;
import com.xznu.edu.leave.service.*;
import com.xznu.edu.leave.utils.*;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    @Autowired
    private SurveyingZoneService surveyingZoneService;
    @Autowired
    private StaffStatusService staffStatusService;
    @Autowired
    private StaffService staffService;    
    
    private Staff staff;
    private Map<String, Object> map = new HashMap();
    
    private Integer staffId;

    /**
     * list
     *
     * @return
     */
    public String list() {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null) {
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        }
        Pager<Staff> pagers = null;
        Role role = user1.getRole();
        if (role.getEnName().equals("admin")) {
            pagers = staffService.getList(staff);
            ActionContext.getContext().put("pagers", pagers);
            ActionContext.getContext().put("user", user1);
            putSurveyingZonePagersIntoContext();
            
            putStaffStatusPagersIntoContext();
            
            ActionContext.getContext().put("bean", staff);
        }
        return SUCCESS;
    }

    /**
     * list
     *
     * @return
     */
    public String dataList() {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null) {
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        }
        Pager<Staff> pagers = null;
        Role role = user1.getRole();
        if (role.getEnName().equals("admin")) {
            pagers = staffService.getList(staff);
            ActionContext.getContext().put("staffPagers", pagers);
            ActionContext.getContext().put("user", user1);
            
            putSurveyingZonePagersIntoContext();
            
            putStaffStatusPagersIntoContext();
            
            ActionContext.getContext().put("bean", staff);

        }
        return SUCCESS;
    }

	/**
	 * 
	 */
	private void putSurveyingZonePagersIntoContext() {
		Pager<SurveyingZone> pagers2 = surveyingZoneService.getList(null);
		ActionContext.getContext().put("surveyingZonePagers", pagers2);
	}



	/**
	 * 将设置职工状态的列表提取到环境中
	 */
	private void putStaffStatusPagersIntoContext() {
		//获取设置状态的列表
		Pager<StaffStatus> staffStatusPagers = staffStatusService.getList(null);
		ActionContext.getContext().put("staffStatusPagers", staffStatusPagers);
	}

    /**
     * 跳转add
     *
     * @return
     */
    public String add() {
        User user1 = UserUtils.getUser();
        ActionContext.getContext().put("bean", user1);
        return SUCCESS;
    }

    /**
     * 查询修改
     *
     * @return
     */
    public String edit() {
        Staff bean = staffService.findById(staff.getId());
        Pager<Staff> staffPagers = staffService.getList(null);
        ActionContext.getContext().put("staffPagers", staffPagers);
        
        putStaffStatusPagersIntoContext();
        
        ActionContext.getContext().put("bean", bean);
        return SUCCESS;
    }
  

    /**
     * 更新
     *
     * @return
     */
    public void update() throws IOException {
        staffService.updates(staff);
        map.put("flag", true);
        map.put("url", "staff_dataList.do");
        JsonUtils.toJson(map);
    }  


    /**
     * 保存
     *
     * @return
     */
    public String save() throws IOException {
        staffService.save(staff);
        map.put("flag", true);
        map.put("url", "staff_list.do");
        JsonUtils.toJson(map);
        return SUCCESS;
    }

    public void delete() throws IOException {
        staff.setIsDelete(1);
        staffService.updates(staff);
        map.put("flag", true);
        map.put("url", "staff_list.do");
        JsonUtils.toJson(map);
    }

    
    @Override
    public Staff getModel() {
        if (staff == null) {
            staff = new Staff();
        }
        return staff;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}
