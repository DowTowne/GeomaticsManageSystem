package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.NoticeDao;
import com.xznu.edu.leave.dao.UserDao;
import com.xznu.edu.leave.model.Notice;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NoticeDaoImpl extends BaseDaoImpl<Notice> implements NoticeDao {

    @Override
    public Pager<Notice> getList(Notice bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from Notice where isDelete = 0");
        if (bean != null) {
            if (bean.getName() != null && !"".equals(bean.getName())) {
                sb.append(" and name like :name");
                alias.put("name", "%" + bean.getName().trim() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public Notice findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from Notice where isDelete = 0 and id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (Notice) query.uniqueResult();
    }
}
