package com.initial.first_redis_project.fibonacci.controller;

import com.initial.first_redis_project.fibonacci.service.FibService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("fib")
@RequiredArgsConstructor
public class FibController {

    private final FibService service;

    @GetMapping("/{index}")
    Mono<Integer> getFib(@PathVariable int index){
        return Mono.fromSupplier(() -> service.getFib(index));
    }

    @GetMapping("{index}/clear")
    public Mono<Void> clearCache(@PathVariable int index){
        return Mono.fromRunnable(() -> service.cleanCache(index));
    }
}
