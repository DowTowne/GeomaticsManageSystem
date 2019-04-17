package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.Role;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface RoleService extends BaseService<Role> {

    Pager<Role> pagers();

    Role findByEn(String enName);

}
