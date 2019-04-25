package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.SurveyingZone;
import com.xznu.edu.leave.utils.Pager;

public interface SurveyingZoneDao extends BaseDao<SurveyingZone> {

    Pager<SurveyingZone> getList(SurveyingZone bean);
}
