package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.SurveyingZone;
import com.xznu.edu.leave.utils.Pager;

public interface SurveyingZoneService extends BaseService<SurveyingZone> {

    Pager<SurveyingZone> getList(SurveyingZone bean);

    SurveyingZone findById(Integer id);
}
