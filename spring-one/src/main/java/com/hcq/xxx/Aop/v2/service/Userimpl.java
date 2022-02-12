package com.hcq.xxx.Aop.v2.service;

public class Userimpl implements UserDao {

    /**
     * 获取名称
     *
     * @param name 名字
     * @return {@link String}
     */
    @Override
    public String getName(String name) {
        return "他的名字是:"+name;
    }

    /**
     * 获取总和
     *
     * @param id ID号
     * @return {@link Integer}
     */
    @Override
    public Integer getSum(Integer id) {
        return id/0;
    }
}
