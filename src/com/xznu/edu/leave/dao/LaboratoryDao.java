package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.Laboratory;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface LaboratoryDao extends BaseDao<Laboratory> {

    Pager<Laboratory> getList(Laboratory bean);
}
