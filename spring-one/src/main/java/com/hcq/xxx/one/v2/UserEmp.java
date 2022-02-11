package com.hcq.xxx.one.v2;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

@Data
public class UserEmp {

    private String name;

    private List<User> list;

    private Set<User> set;

    private HashMap<String, User> map;

    private Properties properties;
}
