package com.utils;

import lombok.extern.log4j.Log4j;

import java.util.stream.Stream;


@Log4j
public class Myutils {

    /**
     * 打印错误
     *
     * @param obk 好
     */
    public static void printlnErr(Object... obk) {
        Stream.of(obk).forEach(System.err::println);
    }

    /**
     * 打印日志
     *
     * @param obk 好
     */
    public static void printlnLog(Object... obk) {
        Stream.of(obk).forEach(log::info);
    }
}
