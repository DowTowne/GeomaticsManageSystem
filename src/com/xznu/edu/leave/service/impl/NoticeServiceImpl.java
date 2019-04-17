package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.NoticeDao;
import com.xznu.edu.leave.dao.UserDao;
import com.xznu.edu.leave.model.Notice;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.NoticeService;
import com.xznu.edu.leave.service.UserService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice> implements NoticeService {
	@Autowired
     private NoticeDao dao;

    @Override
    public Pager<Notice> getList(Notice bean){
        return dao.getList(bean);}

    @Override
    public Notice findById(Integer id) {
        return dao.findById(id);
    }

}
