package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.StaffStatus;
import com.xznu.edu.leave.utils.Pager;

public interface StaffStatusDao extends BaseDao<StaffStatus> {

    Pager<StaffStatus> getList(StaffStatus bean);
}
