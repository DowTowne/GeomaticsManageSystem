package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.UserDao;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.UserService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Autowired
     private UserDao userDao;

    @Override
    public User getUser(User user){return userDao.getUser(user);}

    @Override
    public Pager<User> getList(User user){
        return userDao.getList(user);}

    @Override
    public List<User> getListAdmin() {
        return userDao.getListAdmin();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

}
