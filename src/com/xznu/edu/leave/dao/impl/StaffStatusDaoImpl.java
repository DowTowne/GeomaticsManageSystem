package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.StaffStatusDao;
import com.xznu.edu.leave.model.StaffStatus;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StaffStatusDaoImpl extends BaseDaoImpl<StaffStatus> implements StaffStatusDao {

    @Override
    public Pager<StaffStatus> getList(StaffStatus bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from StaffStatus where isDelete = 0");
        if (bean != null) {
            if (bean.getName() != null && !"".equals(bean.getName())) {
                sb.append(" and name like :name");
                alias.put("name", "%" + bean.getName().trim() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public StaffStatus findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from StaffStatus where isDelete = 0 and id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (StaffStatus) query.uniqueResult();
    }
}
