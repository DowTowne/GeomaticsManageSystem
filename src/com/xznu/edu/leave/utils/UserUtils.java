package com.xznu.edu.leave.utils;

import com.opensymphony.xwork2.ActionContext;
import com.xznu.edu.leave.model.User;
import org.apache.commons.collections.map.HashedMap;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/12 0012.
 */
public class UserUtils {

//    public static Map<String, User> getUser() throws IOException {
//        User user = new User();
//        String users = "";
//        Map<String, User> map = new HashedMap();
//        for (int i = 0; i < 3; i++) {
//            if (i == 0){
//                users = "user";
//            } else {
//                users = users + i;
//            }
//            if (ActionContext.getContext().getSession().get(users) != null){
//                user = (User) ActionContext.getContext().getSession().get(users);
//                map.put(users, user);
//            }
//        }
//        return map;
//    }

    public static User getUser(){
        User user = new User();
        String users = "user";
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                user = (User) ActionContext.getContext().getSession().get(users);
            } else {
                String user1 = users + i;
                if (ActionContext.getContext().getSession().get(user1) != null) {
                    user = (User) ActionContext.getContext().getSession().get(user1);
                }
            }
        }
        return user;
    }
}
