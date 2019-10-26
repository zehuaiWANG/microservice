package com.pagerank.service2.controller;

import com.pagerank.service2.utils.FindMedianSortedArrays;
import com.pagerank.service2.utils.Insert;
import com.pagerank.service2.utils.IsMatch;
import com.pagerank.service2.utils.Matrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class Service2Controller {

    @GetMapping("/cpuSmallest")
    public int[][] cpuSmallest() {
        return cpuTest1(100, 100);
    }

    @GetMapping("/meaningless")
    public String meaningless() {
        return "ok";
    }

    @GetMapping("/find_median_sorted")
    public double findMedianSorted() {
        return FindMedianSortedArrays.findMedianSortedArrays(
            new int[]{1, 2},
            new int[]{3, 4}
        );
    }

    @GetMapping("/is_match")
    public boolean isMatch() {
        return IsMatch.isMatch("aa", "a*");
    }

    @GetMapping("/insert_into")
    public double insertInto() {
        return Insert.myPow(8.88023, 3);
    }

    public int[][] cpuTest1(int i1, int j1) {
        int[][] ma1 = Matrix.createMatrix(i1, j1);
        int[][] ma2 = Matrix.createMatrix(i1, j1);
        int[][] m3 = new int[i1][j1];
        try {
            m3 = Matrix.multiplication(ma1, ma2);
        } catch (Exception e) {

        }
        return m3;
    }

}
