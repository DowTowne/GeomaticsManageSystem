package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.LaboratoryLogDao;
import com.xznu.edu.leave.model.LaboratoryLog;
import com.xznu.edu.leave.service.LaboratoryLogService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratoryLogServiceImpl extends BaseServiceImpl<LaboratoryLog> implements LaboratoryLogService {
	@Autowired
     private LaboratoryLogDao dao;

    @Override
    public Pager<LaboratoryLog> getList(LaboratoryLog bean){
        return dao.getList(bean);}

    @Override
    public LaboratoryLog findById(Integer id) {
        return dao.findById(id);
    }

}
