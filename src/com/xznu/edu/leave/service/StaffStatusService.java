package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.StaffStatus;
import com.xznu.edu.leave.utils.Pager;

public interface StaffStatusService extends BaseService<StaffStatus> {

    Pager<StaffStatus> getList(StaffStatus bean);

    StaffStatus findById(Integer id);
}
