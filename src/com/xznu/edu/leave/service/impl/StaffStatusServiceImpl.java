package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.StaffStatusDao;
import com.xznu.edu.leave.model.StaffStatus;
import com.xznu.edu.leave.service.StaffStatusService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffStatusServiceImpl extends BaseServiceImpl<StaffStatus> implements StaffStatusService {
	@Autowired
     private StaffStatusDao dao;

    @Override
    public Pager<StaffStatus> getList(StaffStatus bean){
        return dao.getList(bean);}

    @Override
    public StaffStatus findById(Integer id) {
        return dao.findById(id);
    }

}
