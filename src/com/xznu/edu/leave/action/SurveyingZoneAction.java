package com.xznu.edu.leave.action;

/**
 * 用户新增
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.Role;
import com.xznu.edu.leave.model.Staff;
import com.xznu.edu.leave.model.SurveyingZone;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.RoleService;
import com.xznu.edu.leave.service.StaffService;
import com.xznu.edu.leave.service.SurveyingZoneService;
import com.xznu.edu.leave.service.UserService;
import com.xznu.edu.leave.utils.JsonUtils;
import com.xznu.edu.leave.utils.Pager;
import com.xznu.edu.leave.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller("surveyingzoneAction")
@Scope("prototype")
public class SurveyingZoneAction extends ActionSupport implements ModelDriven<SurveyingZone> {
    
    @Autowired
    private SurveyingZoneService surveyingZoneService;
    
    @Autowired
    private StaffService staffService;
    
    private User user;
    private SurveyingZone surveyingZone;
    private Integer surveyingZoneId;
    private Map<String, Object> map = new HashMap();


    /**
	 * 将职工列表提取到环境中
	 */
	private void putStaffPagersIntoContext() {
		//获取职工的列表
		Pager<Staff> staffPagers = staffService.getList(null);
		ActionContext.getContext().put("staffPagers", staffPagers);
	}
    
    /**
     * 查询出的清单list
     *
     * @return
     */
    public String list(){
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null){
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        }
        Pager<SurveyingZone> pagers = null;
        Role role = user1.getRole();
        if (role.getEnName().equals("admin") || role.getEnName().equals("js")) {
            pagers = surveyingZoneService.getList(surveyingZone);
            ActionContext.getContext().put("pagers", pagers);
            ActionContext.getContext().put("user", user1);
            putStaffPagersIntoContext();
            ActionContext.getContext().put("surveyingZone", surveyingZone);
        }
        return SUCCESS;
    }

     

    
    /**
     * 跳转add
     *
     * @return
     */
    public String add(){
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
        if (surveyingZoneId != null && !surveyingZoneId.equals("")){
        	SurveyingZone bean = surveyingZoneService.findById(surveyingZoneId);
            ActionContext.getContext().put("bean", bean);
        }
        return SUCCESS;
    }


    /**
     * 更新
     *
     * @return
     */
    public void update() throws IOException {
    	surveyingZoneService.updates(surveyingZone);
        map.put("flag", true);
        map.put("url", "surveyingzone_list.do");
        JsonUtils.toJson(map);
    }

    /**
     * 保存
     *
     * @return
     */
    public String save() throws IOException {    	
    	surveyingZoneService.save(surveyingZone);
        map.put("flag", true);
        map.put("url", "surveyingzone_list.do");
        JsonUtils.toJson(map);
        return SUCCESS;
    }

    /*删除
     */
    public void delete() throws IOException {
    	surveyingZone.setIsDelete(1);
    	surveyingZoneService.updates(surveyingZone);
        map.put("flag", true);
        map.put("url", "surveyingzone_list.do");
        JsonUtils.toJson(map);
    }

    @Override
    public SurveyingZone getModel() {
        if (surveyingZone == null) {
        	surveyingZone = new SurveyingZone();
        }
        return surveyingZone;
    }

    public Integer getSurveyingZoneId() {
        return surveyingZoneId;
    }

    public void setSurveyingZoneId(Integer surveyingZoneId) {
        this.surveyingZoneId = surveyingZoneId;
    }

}
