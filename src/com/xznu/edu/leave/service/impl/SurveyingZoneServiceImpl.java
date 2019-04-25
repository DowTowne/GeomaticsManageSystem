package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.SurveyingZoneDao;
import com.xznu.edu.leave.model.SurveyingZone;
import com.xznu.edu.leave.service.SurveyingZoneService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyingZoneServiceImpl extends BaseServiceImpl<SurveyingZone> implements SurveyingZoneService {
	@Autowired
     private SurveyingZoneDao dao;

    @Override
    public Pager<SurveyingZone> getList(SurveyingZone bean){
        return dao.getList(bean);}

    @Override
    public SurveyingZone findById(Integer id) {
        return dao.findById(id);
    }

}
