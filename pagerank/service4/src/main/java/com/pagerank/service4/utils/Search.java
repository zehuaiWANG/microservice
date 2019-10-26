package com.pagerank.service4.utils;

/**
 * Copyright: Copyright (c) 2019 Chainext
 *
 * @Name: Search
 * @Description: TODO
 * @Author: Goody
 * @CreateTime: 2019/4/19 17:10
 * @Version: 1.0.0
 */

public class Search {
    public static int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1, mid;

        while (l <= r) {

            mid = l + r >>> 1;

            if (nums[mid] == target) return mid;

            else if (nums[mid] >= nums[l]) {

                if (nums[l] <= target && target < nums[mid]) r = mid - 1;

                else l = mid + 1;

            } else {

                if (nums[mid] < target && target <= nums[r]) l = mid + 1;

                else r = mid - 1;

            }

        }

        return -1;

    }
}
