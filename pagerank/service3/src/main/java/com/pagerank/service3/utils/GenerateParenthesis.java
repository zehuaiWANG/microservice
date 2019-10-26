package com.pagerank.service3.utils;

import java.util.ArrayList;

import java.util.Collections;

import java.util.HashMap;

import java.util.List;

/**
 * Copyright: Copyright (c) 2019 Chainext
 *
 * @Name: GenerateParenthesis
 * @Description: TODO
 * @Author: Goody
 * @CreateTime: 2019/4/19 17:13
 * @Version: 1.0.0
 */

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {

        HashMap<Integer, List<String>> hashMap = new HashMap<>();

        hashMap.put(0, Collections.singletonList(""));

        for (int i = 1; i <= n; i++) {

            List<String> list = new ArrayList<>();

            for (int j = 0; j < i; j++) {

                for (String fj : hashMap.get(j)) {

                    for (String fi_j_1 : hashMap.get(i - j - 1)) {

                        list.add("(" + fj + ")" + fi_j_1);// calculate f(i)

                    }

                }

            }

            hashMap.put(i, list);

        }

        return hashMap.get(n);

    }
}
