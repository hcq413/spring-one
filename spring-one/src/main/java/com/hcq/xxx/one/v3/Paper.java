package com.hcq.xxx.one.v3;

import lombok.Data;

/**
 * 纸
 *
 * @author 黄昌其
 * @date 2022/02/11
 */
@Data
public class Paper {
    /**
     * 纸屑
     */
    private String papertyoe;

    /**
     * 纸面价格
     */
    private Double paperprice;

    /**
     * 显示
     */
    public  void show(){
        System.out.println("当前纸的类型:"+getPapertyoe());
    }

    /**
     * 价格
     */
    public  void  price(){
        System.out.println("当前纸的价格:"+getPaperprice());
    }
}
