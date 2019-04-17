package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.EquipmentStatusDao;
import com.xznu.edu.leave.model.EquipmentStatus;
import com.xznu.edu.leave.service.EquipmentStatusService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentStatusServiceImpl extends BaseServiceImpl<EquipmentStatus> implements EquipmentStatusService {
	@Autowired
     private EquipmentStatusDao dao;

    @Override
    public Pager<EquipmentStatus> getList(EquipmentStatus bean){
        return dao.getList(bean);}

    @Override
    public EquipmentStatus findById(Integer id) {
        return dao.findById(id);
    }

}
