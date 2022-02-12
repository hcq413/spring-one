package com.hcq.xxx.Aop.v3.service;

import org.springframework.context.annotation.EnableAspectJAutoProxy;


public class UserServiceImpl implements UserService {
    @Override
    public String finduserId(String userid) {
        return "查询编号为"+userid+"的用户";
    }

    @Override
    public String add(String userid) {
        System.out.println("调用了add方法");
        throw new RuntimeException("增加用户错误!!!");
    }
}
