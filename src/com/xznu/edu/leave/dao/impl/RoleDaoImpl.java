package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.RoleDao;
import com.xznu.edu.leave.dao.UserDao;
import com.xznu.edu.leave.model.Role;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {


    @Override
    public Pager<Role> pagers() {
        String hql = "from Role where enName <> 'admin' ";
        return findByAlias(hql, null);
    }

    @Override
    public Role findByEn(String enName) {
        StringBuilder sb = new StringBuilder();
        sb.append("from Role where enName = :enName");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("enName", enName);
        return (Role) query.uniqueResult();
    }
}
