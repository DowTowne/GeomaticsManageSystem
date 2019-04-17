package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.EquipmentDao;
import com.xznu.edu.leave.dao.LaboratoryDao;
import com.xznu.edu.leave.model.Equipment;
import com.xznu.edu.leave.model.Laboratory;
import com.xznu.edu.leave.service.EquipmentService;
import com.xznu.edu.leave.service.LaboratoryService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl extends BaseServiceImpl<Equipment> implements EquipmentService {
	@Autowired
     private EquipmentDao dao;

    @Override
    public Pager<Equipment> getList(Equipment bean){
        return dao.getList(bean);}

    @Override
    public Equipment findById(Integer id) {
        return dao.findById(id);
    }

}
