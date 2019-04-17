package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.Notice;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface NoticeDao extends BaseDao<Notice> {


    Pager<Notice> getList(Notice bean);

    Notice findById(Integer id);



}
