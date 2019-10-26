package com.pagerank.service3.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Copyright: Copyright (c) 2019 Chainext
 *
 * @Name: FullJustify
 * @Description: TODO
 * @Author: Goody
 * @CreateTime: 2019/4/19 16:14
 * @Version: 1.0.0
 */

public class FullJustify {

    public static List<String> fullJustify(String[] words, int maxWidth) {

        int len = words.length;

        if (len == 0) return Collections.emptyList();

        List<String> ans = new ArrayList<>();

        StringBuilder spaces = new StringBuilder();

        for (int i = 0; i < maxWidth; ++i) {

            spaces.append(" ");

        }

        int sLen = -1, left = 0;

        for (int i = 0; i < len; ++i) {

            if (sLen + words[i].length() + 1 <= maxWidth) {

                sLen += words[i].length() + 1;

            } else {

                StringBuilder sub = new StringBuilder(words[left]);

                int rest = maxWidth - sLen;

                int seg = i - left;

                if (seg == 0) {

                    sub.append(spaces.substring(0, rest));

                } else {

                    int leastSpace = rest / seg + 1;

                    int restSpace = rest % seg;

                    for (int j = left + 1; j < i; ++j) {

                        if (restSpace-- > 0) {

                            sub.append(spaces.substring(0, leastSpace + 1)).append(words[j]);

                        } else {

                            sub.append(spaces.substring(0, leastSpace)).append(words[j]);

                        }

                    }

                }

                ans.add(sub.toString());

                left = i;

                sLen = words[i].length();

            }

        }

        StringBuilder sub = new StringBuilder(words[left]);

        for (int i = left + 1; i < len; ++i) {

            sub.append(" ").append(words[i]);

        }

        ans.add(sub + spaces.substring(0, maxWidth - sub.length()));

        return ans;

    }

}
