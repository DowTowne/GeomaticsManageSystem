package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.StaffDao;
import com.xznu.edu.leave.model.Staff;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {

    @Override
    public Pager<Staff> getList(Staff bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from Staff where isDelete = 0");
        if (bean != null) {
            if (bean.getName() != null && !"".equals(bean.getName())) {
                sb.append(" and name like :name");
                alias.put("name", "%" + bean.getName().trim() + "%");
            }
            if (bean.getSurveyingZone() != null && !"".equals(bean.getSurveyingZone())) {
                sb.append(" and surveyingZone.name like :surveyingZonename");
                alias.put("surveyingZonename", "%" + bean.getSurveyingZone().getName() + "%");
            }
            if (bean.getPhone() != null && !"".equals(bean.getPhone())) {
                sb.append(" and phone like :phone");
                alias.put("phone", "%" + bean.getPhone().trim() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public List<Staff> getListAdmin() {
        StringBuilder sb = new StringBuilder();
        sb.append("from Staff where isDelete = 0 and role.enName = :admin");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("admin", "admin");
        return query.list();
    }

    @Override
    public Staff getStaff(Staff staff) {
        StringBuilder sb = new StringBuilder();
        sb.append("from User where isDelete = 0");
        if (staff.getName() != null && !staff.getName().equals("")) {
            sb.append(" and name = :name");
        }
        if (staff.getPass() != null && !staff.getPass().equals("")) {
            sb.append(" and pass = :pass");
        }
        Query query = getSession().createQuery(sb.toString());
        if (staff.getName() != null && !staff.getName().equals("")) {
            query.setParameter("name", staff.getName().trim());
        }
        if (staff.getPass() != null && !staff.getPass().equals("")) {
            query.setParameter("pass", staff.getPass().trim());
        }
        List<Staff> list = query.list();
        if (list.size() > 0) {
            return (Staff) query.list().get(0);
        }
        return null;
    }

    @Override
    public Staff findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from Staff where isDelete = 0 and id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (Staff) query.uniqueResult();
    }
}
