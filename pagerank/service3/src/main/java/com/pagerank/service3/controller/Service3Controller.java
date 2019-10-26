package com.pagerank.service3.controller;

import com.pagerank.service3.utils.FindSubstring;
import com.pagerank.service3.utils.FullJustify;
import com.pagerank.service3.utils.GenerateParenthesis;
import com.pagerank.service3.utils.Matrix;
import com.pagerank.service3.utils.Multiply;
import com.pagerank.service3.utils.Node;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service3")
public class Service3Controller {

    @GetMapping("/memoryBiggest")
    public String memoryBiggest() {
        return memoryTest(500);
    }

    @GetMapping("/meaningless")
    public String meaningless() {
        return "ok";
    }

    @GetMapping("/find_substring")
    public List<Integer> findSubstring() {
        return FindSubstring
            .findSubstring("wordgoodgoodgoodbestword",
                new String[]{"word", "good", "best", "good"});
    }

    @GetMapping("/full_justiy")
    public List<String> fullJustiy() {
        return FullJustify.fullJustify(
            new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }

    @GetMapping("/multiply")
    public String Multiply() {
        return Multiply.multiply("132", "19");
    }

    @GetMapping("/generate")
    public List<String> generateParenthesis(){
        return GenerateParenthesis.generateParenthesis(3);
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
