package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.EquipmentStatus;
import com.xznu.edu.leave.utils.Pager;

public interface EquipmentStatusDao extends BaseDao<EquipmentStatus> {

    Pager<EquipmentStatus> getList(EquipmentStatus bean);
}
