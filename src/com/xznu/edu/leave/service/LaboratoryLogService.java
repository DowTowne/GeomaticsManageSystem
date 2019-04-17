package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.LaboratoryLog;
import com.xznu.edu.leave.utils.Pager;

public interface LaboratoryLogService extends BaseService<LaboratoryLog> {

    Pager<LaboratoryLog> getList(LaboratoryLog bean);

    LaboratoryLog findById(Integer id);
}
