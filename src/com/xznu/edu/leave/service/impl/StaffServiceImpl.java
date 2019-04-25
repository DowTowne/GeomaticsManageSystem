package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.StaffDao;
import com.xznu.edu.leave.dao.UserDao;
import com.xznu.edu.leave.model.Staff;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.StaffService;
import com.xznu.edu.leave.service.UserService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl extends BaseServiceImpl<Staff> implements StaffService {
	@Autowired
     private StaffDao staffDao;

    @Override
    public Staff getStaff(Staff staff){return staffDao.getStaff(staff);}

    @Override
    public Pager<Staff> getList(Staff staff){
        return staffDao.getList(staff);}

    @Override
    public List<Staff> getListAdmin() {
        return staffDao.getListAdmin();
    }

    @Override
    public Staff findById(Integer id) {
        return staffDao.findById(id);
    }

}
