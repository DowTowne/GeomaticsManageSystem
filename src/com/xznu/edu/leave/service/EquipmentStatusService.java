package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.EquipmentStatus;
import com.xznu.edu.leave.utils.Pager;

public interface EquipmentStatusService extends BaseService<EquipmentStatus> {

    Pager<EquipmentStatus> getList(EquipmentStatus bean);

    EquipmentStatus findById(Integer id);
}
