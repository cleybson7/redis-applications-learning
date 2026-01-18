package com.initial.first_redis_project.fibonacci.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FibService {

    @Cacheable(value = "math:fib", key = "#index")
    public int getFib(int index){
        System.out.println("calculando fibonacci: "+index);
        return fib(index);
    }

    @CacheEvict(value = "math:fib", key = "#index")
    public void cleanCache(int index){
        System.out.println("Clearing hash key");
    }

    @Scheduled(fixedRate = 10_000)
    @CacheEvict(value = "math:fib", allEntries = true)
    public void cleanCache(){
        System.out.println("Clearing hash key");
    }

    private int fib(int index){
        if (index < 2){
            return index;
        }
        return fib(index - 1) + fib(index - 2);
    }
}
