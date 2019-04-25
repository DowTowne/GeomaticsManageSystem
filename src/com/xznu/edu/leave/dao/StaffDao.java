package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.Staff;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface StaffDao extends BaseDao<Staff> {

	Staff getStaff(Staff staff);

    Pager<Staff> getList(Staff staff);

    Staff findById(Integer id);

    List<Staff> getListAdmin();


}
