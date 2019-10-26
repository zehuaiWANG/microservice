package com.pagerank.service2.utils;

/**
 * Copyright: Copyright (c) 2019 Chainext
 *
 * @Name: FindMedianSortedArrays
 * @Description: TODO
 * @Author: Goody
 * @CreateTime: 2019/4/19 15:54
 * @Version: 1.0.0
 */

public class FindMedianSortedArrays {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len = nums1.length + nums2.length;
    if (len % 2 == 0) {
      return (helper(nums1, 0, nums2, 0, len / 2) + helper(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    }
    return helper(nums1, 0, nums2, 0, (len + 1) / 2);
  }

  private static int helper(int[] nums1, int m, int[] nums2, int n, int k) {

    if (m >= nums1.length) {
      return nums2[n + k - 1];
    }

    if (n >= nums2.length) {
      return nums1[m + k - 1];
    }

    if (k == 1) {
      return Math.min(nums1[m], nums2[n]);
    }

    int p1 = m + k / 2 - 1;
    int p2 = n + k / 2 - 1;
    int mid1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
    int mid2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;

    if (mid1 < mid2) {
      return helper(nums1, m + k / 2, nums2, n, k - k / 2);
    }

    return helper(nums1, m, nums2, n + k / 2, k - k / 2);

  }

}
