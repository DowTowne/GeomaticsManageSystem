package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.SurveyingZoneDao;
import com.xznu.edu.leave.model.SurveyingZone;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SurveyingZoneDaoImpl extends BaseDaoImpl<SurveyingZone> implements SurveyingZoneDao {

    @Override
    public Pager<SurveyingZone> getList(SurveyingZone bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from SurveyingZone where isDelete = 0");
        if (bean != null) {
            if (bean.getName() != null && !"".equals(bean.getName())) {
                sb.append(" and name like :name");
                alias.put("name", "%" + bean.getName().trim() + "%");
            }
            if (bean.getDirector() != null && !"".equals(bean.getDirector())) {
                sb.append(" and director.name like :directorname");
                alias.put("directorname", "%" + bean.getDirector().getName() + "%");
            }
            if (bean.getAddress() != null && !"".equals(bean.getAddress())) {
                sb.append(" and address like :address");
                alias.put("address", "%" + bean.getAddress().trim() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public SurveyingZone findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from SurveyingZone where isDelete = 0 and id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (SurveyingZone) query.uniqueResult();
    }
}
