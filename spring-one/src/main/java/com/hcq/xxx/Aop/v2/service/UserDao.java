package com.hcq.xxx.Aop.v2.service;

public interface UserDao {


    /**
     * 获取名称
     * @param name 名字
     * @return {@link String}
     */
    String getName(String name);

    /**
     * 获取总和
     *
     * @param id ID号
     * @return {@link Integer}
     */
    Integer getSum(Integer id);
}
