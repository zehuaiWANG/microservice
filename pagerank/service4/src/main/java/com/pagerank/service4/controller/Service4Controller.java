package com.pagerank.service4.controller;

import com.pagerank.service4.utils.Divide;
import com.pagerank.service4.utils.GroupAnagrams;
import com.pagerank.service4.utils.Matrix;
import com.pagerank.service4.utils.Node;
import com.pagerank.service4.utils.Search;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service4")
public class Service4Controller {

    @GetMapping("/memorySmallest")
    public String memorySmaller() {
        return memoryTest(100);
    }

    @GetMapping("/meaningless")
    public String meaningless() {
        return "ok";
    }

    @GetMapping("/divide")
    public int divide() {
        return Divide.divide(-2147483648, 1);
    }

    @GetMapping("/group_anagrams")
    public List<List<String>> groupAnagrams() {
        return GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    @GetMapping("/search")
    public int search() {
        return Search.search(new int[]{2, 1}, 1);
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

    public String memoryTest(int count) {
        Node[] nodes = new Node[count];
        for (int i = 0; i < count; i++) {
            nodes[i] = new Node();
        }
        return "ok";
    }
}
