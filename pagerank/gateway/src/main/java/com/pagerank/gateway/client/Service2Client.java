package com.pagerank.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service2")
@Service
public interface Service2Client {

    @GetMapping("/service2/cpuSmallest")
    int[][] cpuSmallest();

    @GetMapping("/service2/meaningless")
    String meaningless();

    @GetMapping("/service2/find_median_sorted")
    double findMedianSorted();

    @GetMapping("/service2/is_match")
    boolean isMatch();

    @GetMapping("/service2/insert_into")
    double insertInto();
}
