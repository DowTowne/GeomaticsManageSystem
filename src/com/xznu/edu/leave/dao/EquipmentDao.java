package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.Equipment;
import com.xznu.edu.leave.model.Laboratory;
import com.xznu.edu.leave.utils.Pager;

public interface EquipmentDao extends BaseDao<Equipment> {

    Pager<Equipment> getList(Equipment bean);
}
