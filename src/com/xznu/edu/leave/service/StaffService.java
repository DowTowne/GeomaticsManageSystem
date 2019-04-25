package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.Staff;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;
import java.util.List;

public interface StaffService extends BaseService<Staff> {

	Staff getStaff(Staff staff);

    Pager<Staff> getList(Staff staff);

    List<Staff> getListAdmin();

    Staff findById(Integer id);
}
