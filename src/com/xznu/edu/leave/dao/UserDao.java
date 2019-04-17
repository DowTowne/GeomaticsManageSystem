package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    User getUser(User user);

    Pager<User> getList(User user);

    User findById(Integer id);

    List<User> getListAdmin();


}
