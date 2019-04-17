package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.LaboratoryDao;
import com.xznu.edu.leave.dao.UserDao;
import com.xznu.edu.leave.model.Laboratory;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LaboratoryDaoImpl extends BaseDaoImpl<Laboratory> implements LaboratoryDao {

    @Override
    public Pager<Laboratory> getList(Laboratory bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from Laboratory where isDelete = 0");
        if (bean != null) {
            if (bean.getName() != null && !"".equals(bean.getName())) {
                sb.append(" and name like :name");
                alias.put("name", "%" + bean.getName().trim() + "%");
            }
            if (bean.getFzr() != null && !"".equals(bean.getFzr())) {
                sb.append(" and fzr like :fzr");
                alias.put("fzr", "%" + bean.getFzr().trim() + "%");
            }
            if (bean.getIsYy() != null && !"".equals(bean.getIsYy())) {
                sb.append(" and isYy = :isYy");
                alias.put("isYy", bean.getIsYy());
            }
            if (bean.getUser() != null && bean.getUser().getName() != null && !"".equals(bean.getUser().getName())) {
                sb.append(" and user.name like :username");
                alias.put("username", "%" + bean.getUser().getName() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public Laboratory findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from Laboratory where isDelete = 0 and id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (Laboratory) query.uniqueResult();
    }
}
