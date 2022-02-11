package com.hcq.xxx.one.utils;

import java.util.function.Supplier;

/**
 * 我工具
 *
 * @author 黄昌其
 * @date 2022/02/11
 */
public class Mytools {

    /**
     * 打印
     *
     * @param supplier 供应商
     */
    public static void println(Supplier<?> supplier) {
        System.out.println(supplier.get());
    }

    /**
     * 打印
     *
     * @param supplier 供应商
     */
    public static void print(Supplier<?> supplier) {
        System.out.println(supplier.get());
    }
}
