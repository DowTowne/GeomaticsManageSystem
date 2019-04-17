package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.Laboratory;
import com.xznu.edu.leave.model.LaboratoryLog;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;

public interface LaboratoryLogDao extends BaseDao<LaboratoryLog> {

    Pager<LaboratoryLog> getList(LaboratoryLog bean);

    LaboratoryLog findById(Integer id);
}
