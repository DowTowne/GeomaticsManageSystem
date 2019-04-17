package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.LaboratoryLog;
import com.xznu.edu.leave.model.RepairLog;
import com.xznu.edu.leave.utils.Pager;

public interface RepairLogService extends BaseService<RepairLog> {

    Pager<RepairLog> getList(RepairLog bean);

    RepairLog findById(Integer id);
}
