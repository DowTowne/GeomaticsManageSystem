package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.Laboratory;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface LaboratoryService extends BaseService<Laboratory> {

    Pager<Laboratory> getList(Laboratory bean);

    Laboratory findById(Integer id);
}
