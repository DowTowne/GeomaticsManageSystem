package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.LaboratoryLog;
import com.xznu.edu.leave.model.RepairLog;
import com.xznu.edu.leave.utils.Pager;

public interface RepairLogDao extends BaseDao<RepairLog> {

    Pager<RepairLog> getList(RepairLog bean);

    RepairLog findById(Integer id);
}
