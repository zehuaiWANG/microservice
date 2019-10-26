package com.pagerank.service4.utils;

/**
 * Copyright: Copyright (c) 2019 Chainext
 *
 * @Name: Divide
 * @Description: TODO
 * @Author: Goody
 * @CreateTime: 2019/4/19 16:18
 * @Version: 1.0.0
 */

public class Divide {
    public static int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {

            return Integer.MAX_VALUE;

        }

        long dvd = Math.abs((long) dividend);

        long dvr = Math.abs((long) divisor);

        int res = 0;

        while (dvd >= dvr) {

            long temp = dvr, multiple = 1;

            while (dvd >= temp << 1) {

                temp <<= 1;

                multiple <<= 1;

            }

            dvd -= temp;

            res += multiple;

        }

        return (dividend < 0) ^ (divisor < 0) ? -res : res;

    }


}
