package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.LaboratoryDao;
import com.xznu.edu.leave.dao.UserDao;
import com.xznu.edu.leave.model.Laboratory;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.LaboratoryService;
import com.xznu.edu.leave.service.UserService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryServiceImpl extends BaseServiceImpl<Laboratory> implements LaboratoryService {
	@Autowired
     private LaboratoryDao dao;

    @Override
    public Pager<Laboratory> getList(Laboratory bean){
        return dao.getList(bean);}

    @Override
    public Laboratory findById(Integer id) {
        return dao.findById(id);
    }

}
