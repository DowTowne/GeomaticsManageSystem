package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.EquipmentDao;
import com.xznu.edu.leave.dao.EquipmentLogDao;
import com.xznu.edu.leave.model.Equipment;
import com.xznu.edu.leave.model.EquipmentLog;
import com.xznu.edu.leave.service.EquipmentLogService;
import com.xznu.edu.leave.service.EquipmentService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentLogServiceImpl extends BaseServiceImpl<EquipmentLog> implements EquipmentLogService {
	@Autowired
     private EquipmentLogDao dao;

    @Override
    public Pager<EquipmentLog> getList(EquipmentLog bean){
        return dao.getList(bean);}

    @Override
    public EquipmentLog findById(Integer id) {
        return dao.findById(id);
    }

}
