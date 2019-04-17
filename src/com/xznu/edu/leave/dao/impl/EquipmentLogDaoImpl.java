package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.EquipmentDao;
import com.xznu.edu.leave.dao.EquipmentLogDao;
import com.xznu.edu.leave.model.Equipment;
import com.xznu.edu.leave.model.EquipmentLog;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EquipmentLogDaoImpl extends BaseDaoImpl<EquipmentLog> implements EquipmentLogDao {

    @Override
    public Pager<EquipmentLog> getList(EquipmentLog bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from EquipmentLog where 1=1");
        if (bean != null) {
            if (bean.getUser() != null && bean.getUser().getName() != null && !"".equals(bean.getUser().getName())) {
                sb.append(" and user.name like :name");
                alias.put("name", "%" + bean.getUser().getName().trim() + "%");
            }
            if (bean.getQx() != null && bean.getQx().getName() != null && !"".equals(bean.getQx().getName())) {
                sb.append(" and qx.name like :names");
                alias.put("names", "%" + bean.getQx().getName().trim() + "%");
            }
            if (bean.getEquipment() != null && bean.getEquipment().getXh() != null && !"".equals(bean.getEquipment().getXh())) {
                sb.append(" and equipment.xh like :xh");
                alias.put("xh", "%" + bean.getEquipment().getXh().trim() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public EquipmentLog findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from EquipmentLog where id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (EquipmentLog) query.uniqueResult();
    }
}
