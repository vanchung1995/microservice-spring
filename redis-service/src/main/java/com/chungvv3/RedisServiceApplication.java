package com.chungvv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@Configuration
public class RedisServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisServiceApplication.class, args);
    }

    @CacheEvict(allEntries = true, value = {"users"})
    @Scheduled(fixedDelay = 6 * 1_000)
    public void reportCacheEvict() {
        System.out.println("Evict Cache");
    }
}