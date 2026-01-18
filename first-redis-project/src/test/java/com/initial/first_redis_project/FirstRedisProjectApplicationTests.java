package com.initial.first_redis_project;

import org.junit.jupiter.api.RepeatedTest;
import org.redisson.api.RAtomicLongReactive;
import org.redisson.api.RedissonReactiveClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class FirstRedisProjectApplicationTests {

    @Autowired
    private ReactiveStringRedisTemplate template;

    @RepeatedTest(3)
	void springDataRedisTest() {
        long start = System.nanoTime();

        ReactiveValueOperations<String, String> valueOperations = this.template.opsForValue();
        Mono<Void> mono = Flux.range(1, 500_000)
                .flatMap(i -> valueOperations.increment("user:1:visit"))
                .then()
                .doFinally(signalType -> {
                    long applicationDuration = (System.nanoTime() - start) / 1_000_000;
                    System.out.println("Tempo da aplicação: "+applicationDuration+"ms");
                });
        StepVerifier.create(mono)
                .verifyComplete();
	}

}
