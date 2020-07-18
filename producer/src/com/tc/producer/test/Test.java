package com.tc.producer.test;

import java.util.Random;

/**
 * @author Mr. Li xiaogao 2020-05-29 22:02
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            System.out.println("random = " + random.nextInt(10));
        }
        Random random1 = new Random(10);
        for (int i = 0; i < 10; i++) {
            System.out.println("random1 = " + random1.nextInt(10));
        }
    }
}
