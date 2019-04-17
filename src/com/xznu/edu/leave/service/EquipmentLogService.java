package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.Equipment;
import com.xznu.edu.leave.model.EquipmentLog;
import com.xznu.edu.leave.utils.Pager;

public interface EquipmentLogService extends BaseService<EquipmentLog> {

    Pager<EquipmentLog> getList(EquipmentLog bean);

    EquipmentLog findById(Integer id);
}
