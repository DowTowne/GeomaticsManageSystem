package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.LaboratoryLogDao;
import com.xznu.edu.leave.dao.RepairLogDao;
import com.xznu.edu.leave.model.LaboratoryLog;
import com.xznu.edu.leave.model.RepairLog;
import com.xznu.edu.leave.service.LaboratoryLogService;
import com.xznu.edu.leave.service.RepairLogService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairLogServiceImpl extends BaseServiceImpl<RepairLog> implements RepairLogService {
	@Autowired
     private RepairLogDao dao;

    @Override
    public Pager<RepairLog> getList(RepairLog bean){
        return dao.getList(bean);}

    @Override
    public RepairLog findById(Integer id) {
        return dao.findById(id);
    }

}
