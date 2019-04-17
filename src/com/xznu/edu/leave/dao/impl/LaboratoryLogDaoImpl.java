package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.LaboratoryLogDao;
import com.xznu.edu.leave.model.LaboratoryLog;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LaboratoryLogDaoImpl extends BaseDaoImpl<LaboratoryLog> implements LaboratoryLogDao {

    @Override
    public Pager<LaboratoryLog> getList(LaboratoryLog bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from LaboratoryLog where 1=1");
        if (bean != null) {
            if (bean.getIsYy() != null && !"".equals(bean.getIsYy())) {
                sb.append(" and isYy = :isYy");
                alias.put("name", bean.getIsYy());
            }
            if (bean.getUser() != null && bean.getUser().getId() != null && !"".equals(bean.getUser().getId())) {
                sb.append(" and user.id = :userId");
                alias.put("userId", bean.getUser().getId());
            }
            if (bean.getUser() != null && bean.getUser().getName() != null && !"".equals(bean.getUser().getName())) {
                sb.append(" and user.name like :name");
                alias.put("name", "%" + bean.getUser().getName() + "%");
            }
            if (bean.getLaboratory() != null && bean.getLaboratory().getId() != null && !"".equals(bean.getLaboratory().getId())) {
                sb.append(" and laboratory.id = :laboratoryId");
                alias.put("laboratoryId", bean.getLaboratory().getId());
            }
            if (bean.getLaboratory() != null && bean.getLaboratory().getName() != null && !"".equals(bean.getLaboratory().getName())) {
                sb.append(" and laboratory.name like :names");
                alias.put("names", "%" + bean.getLaboratory().getName() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public LaboratoryLog findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from LaboratoryLog where id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (LaboratoryLog) query.uniqueResult();
    }
}
