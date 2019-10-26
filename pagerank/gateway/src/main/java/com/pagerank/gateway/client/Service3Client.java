package com.pagerank.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "service3")
@Service
public interface Service3Client {

    @GetMapping("/service3/memoryBiggest")
    String memoryBiggest();

    @GetMapping("/service3/meaningless")
    String meaningless();

    @GetMapping("/service3/find_substring")
    List<Integer> findSubstring();

    @GetMapping("/service3/full_justiy")
    List<String> fullJustiy();

    @GetMapping("/service3/multiply")
    String Multiply();

    @GetMapping("/service3/generate")
    List<String> generateParenthesis();
}
