package com.pagerank.service2.utils;

import java.util.Collections;
import java.util.List;

/**
 * Copyright: Copyright (c) 2019 Chainext
 *
 * @Name: Insert
 * @Description: TODO
 * @Author: Goody
 * @CreateTime: 2019/4/19 17:04
 * @Version: 1.0.0
 */

public class Insert {

    public static double myPow(double x, int n) {
        if (n < 0) {
            return helper(1 / x, -n);
        }
        return helper(x, n);
    }


    private static double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double d = helper(x, n >>> 1);
        if (n % 2 == 0) {
            return d * d;
        }
        return d * d * x;
    }


}
