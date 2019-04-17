package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.Notice;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface NoticeService extends BaseService<Notice> {

    Pager<Notice> getList(Notice bean);

    Notice findById(Integer id);
}
