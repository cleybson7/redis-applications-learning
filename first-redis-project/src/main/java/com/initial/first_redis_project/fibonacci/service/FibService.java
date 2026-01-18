package com.initial.first_redis_project.fibonacci.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class FibService {

    @Cacheable("math:fib")
    public int getFib(int index, String name){
        System.out.println("calculando fibonacci: "+index+", name: "+name);
        return fib(index);
    }

    private int fib(int index){
        if (index < 2){
            return index;
        }
        return fib(index - 1) + fib(index - 2);
    }
}
