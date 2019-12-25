package com.heanes.utils.java.core.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 线程测试
 *
 * @author Heanes
 * @time 2019-12-16 17:51:24 周一
 */
public class ThreadTest extends Thread {

    private String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        List<Long> longList = new ArrayList<Long>(){{
            add(128L);
            add(123L);
            add(124L);
            add(126L);
        }};
        System.out.println(Collections.max(longList));

        ThreadTest mTh1 = new ThreadTest("A");
        ThreadTest mTh2 = new ThreadTest("B");
        mTh1.start();
        mTh2.start();
    }
}
