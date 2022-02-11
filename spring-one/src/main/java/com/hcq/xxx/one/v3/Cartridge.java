package com.hcq.xxx.one.v3;

import lombok.Data;

/**
 * 墨盒
 *
 * @author 黄昌其
 * @date 2022/02/11
 */
@Data
public class Cartridge {
    private String color;

    /**
     * 颜色
     */
    public void color() {
        System.out.println("墨盒颜色:"+getColor());
    }
}
