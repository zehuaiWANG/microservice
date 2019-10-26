package com.pagerank.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service1")
@Service
public interface Service1Client {

    @GetMapping("/service1/cpuBiggest")
    int[][] cpuBiggest();

    @GetMapping("/service1/meaningless")
    String meaningless();

    @GetMapping("/service1/insert")
    int insert();

    @GetMapping("/service1/update")
    int update();

    @GetMapping("/service1/getAll")
    Integer getAll();

    @GetMapping("/service1/delete")
    int delete();

}
