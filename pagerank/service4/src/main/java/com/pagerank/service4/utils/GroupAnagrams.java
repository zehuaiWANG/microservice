package com.pagerank.service4.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2019 Chainext
 *
 * @Name: GroupAnagrams
 * @Description: TODO
 * @Author: Goody
 * @CreateTime: 2019/4/19 17:02
 * @Version: 1.0.0
 */

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return Collections.emptyList();

        List<List<String>> list = new ArrayList<>();

        Map<String, Integer> hash = new HashMap<>();

        int i = 0;

        for (String str : strs) {

            char[] c = str.toCharArray();

            Arrays.sort(c);

            String sortStr = String.valueOf(c);

            if (!hash.containsKey(sortStr)) {

                hash.put(sortStr, i++);

                List<String> sub = new ArrayList<>();

                sub.add(str);

                list.add(sub);

            } else {

                list.get(hash.get(sortStr)).add(str);

            }

        }

        return list;

    }
}
