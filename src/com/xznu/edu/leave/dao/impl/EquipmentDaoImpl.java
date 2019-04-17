package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.EquipmentDao;
import com.xznu.edu.leave.dao.LaboratoryDao;
import com.xznu.edu.leave.model.Equipment;
import com.xznu.edu.leave.model.Laboratory;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EquipmentDaoImpl extends BaseDaoImpl<Equipment> implements EquipmentDao {

    @Override
    public Pager<Equipment> getList(Equipment bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from Equipment where isDelete = 0");
        if (bean != null) {
            if (bean.getXh() != null && !"".equals(bean.getXh())) {
                sb.append(" and xh like :xh");
                alias.put("xh", "%" + bean.getXh().trim() + "%");
            }
            if (bean.getJg() != null && !"".equals(bean.getJg())) {
                sb.append(" and jg = :jg");
                alias.put("jg", bean.getJg());
            }
            if (bean.getZzs() != null && !"".equals(bean.getZzs())) {
                sb.append(" and zzs like :zzs");
                alias.put("zzs", "%" + bean.getZzs().trim() + "%");
            }
            if (bean.getSbxlh() != null && !"".equals(bean.getSbxlh())) {
                sb.append(" and sbxlh like :sbxlh");
                alias.put("sbxlh", "%" + bean.getSbxlh().trim() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public Equipment findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from Equipment where isDelete = 0 and id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (Equipment) query.uniqueResult();
    }
}
