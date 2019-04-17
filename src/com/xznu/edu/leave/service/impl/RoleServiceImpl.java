package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.RoleDao;
import com.xznu.edu.leave.dao.UserDao;
import com.xznu.edu.leave.model.Role;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.RoleService;
import com.xznu.edu.leave.service.UserService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	@Autowired
     private RoleDao roleDao;

    @Override
    public Pager<Role> pagers() {
        return roleDao.pagers();
    }

    @Override
    public Role findByEn(String enName) {
        return roleDao.findByEn(enName);
    }
}
