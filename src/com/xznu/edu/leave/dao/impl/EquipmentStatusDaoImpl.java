package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.EquipmentStatusDao;
import com.xznu.edu.leave.model.EquipmentStatus;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EquipmentStatusDaoImpl extends BaseDaoImpl<EquipmentStatus> implements EquipmentStatusDao {

    @Override
    public Pager<EquipmentStatus> getList(EquipmentStatus bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from EquipmentStatus where isDelete = 0");
        if (bean != null) {
            if (bean.getName() != null && !"".equals(bean.getName())) {
                sb.append(" and name like :name");
                alias.put("name", "%" + bean.getName().trim() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public EquipmentStatus findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from EquipmentStatus where isDelete = 0 and id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (EquipmentStatus) query.uniqueResult();
    }
}
