package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.List;

public interface UserService extends BaseService<User> {

    User getUser(User user);

    Pager<User> getList(User user);

    List<User> getListAdmin();

    User findById(Integer id);
}
