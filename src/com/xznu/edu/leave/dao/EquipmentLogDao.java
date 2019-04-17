package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.Equipment;
import com.xznu.edu.leave.model.EquipmentLog;
import com.xznu.edu.leave.utils.Pager;

public interface EquipmentLogDao extends BaseDao<EquipmentLog> {

    Pager<EquipmentLog> getList(EquipmentLog bean);
}
