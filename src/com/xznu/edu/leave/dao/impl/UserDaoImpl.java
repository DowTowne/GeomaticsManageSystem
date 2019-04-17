package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.UserDao;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public Pager<User> getList(User bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from User where isDelete = 0");
        if (bean != null) {
            if (bean.getRealName() != null && !"".equals(bean.getRealName())) {
                sb.append(" and realName like :realName");
                alias.put("realName", "%" + bean.getRealName().trim() + "%");
            }
            if (bean.getName() != null && !"".equals(bean.getName())) {
                sb.append(" and name like :name");
                alias.put("name", "%" + bean.getName().trim() + "%");
            }
            if (bean.getNumber() != null && !"".equals(bean.getNumber())) {
                sb.append(" and number like :number");
                alias.put("number", "%" + bean.getNumber().trim() + "%");
            }
            if (bean.getPhone() != null && !"".equals(bean.getPhone())) {
                sb.append(" and phone like :phone");
                alias.put("phone", "%" + bean.getPhone().trim() + "%");
            }
            if (bean.getXy() != null && !"".equals(bean.getXy())) {
                sb.append(" and xy like :xy");
                alias.put("xy", "%" + bean.getXy().trim() + "%");
            }
            if (bean.getBj() != null && !"".equals(bean.getBj())) {
                sb.append(" and bj like :bj");
                alias.put("bj", "%" + bean.getBj().trim() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public List<User> getListAdmin() {
        StringBuilder sb = new StringBuilder();
        sb.append("from User where isDelete = 0 and role.enName = :admin");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("admin", "admin");
        return query.list();
    }

    @Override
    public User getUser(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("from User where isDelete = 0");
        if (user.getName() != null && !user.getName().equals("")) {
            sb.append(" and name = :name");
        }
        if (user.getPass() != null && !user.getPass().equals("")) {
            sb.append(" and pass = :pass");
        }
        Query query = getSession().createQuery(sb.toString());
        if (user.getName() != null && !user.getName().equals("")) {
            query.setParameter("name", user.getName().trim());
        }
        if (user.getPass() != null && !user.getPass().equals("")) {
            query.setParameter("pass", user.getPass().trim());
        }
        List<User> list = query.list();
        if (list.size() > 0) {
            return (User) query.list().get(0);
        }
        return null;
    }

    @Override
    public User findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from User where isDelete = 0 and id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (User) query.uniqueResult();
    }
}
