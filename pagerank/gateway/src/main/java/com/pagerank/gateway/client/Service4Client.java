package com.pagerank.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "service4")
@Service
public interface Service4Client {

    @GetMapping("/service4/memorySmallest")
    String memorySmallest();

    @GetMapping("/service4/meaningless")
    String meaningless();

    @GetMapping("/service4/divide")
    int divide();

    @GetMapping("/service4/group_anagrams")
    List<List<String>> groupAnagrams();

    @GetMapping("/service4/search")
    int search();
}
