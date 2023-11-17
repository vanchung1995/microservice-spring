package com.chungvv3.controller;

import com.chungvv3.entities.User;
import com.chungvv3.service.CachingRedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/api/v1")
public class RedisCachingController {

    private final CachingRedisService cachingRedisService;

    public RedisCachingController(CachingRedisService cachingRedisService) {
        this.cachingRedisService = cachingRedisService;
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName) {
        return cachingRedisService.getObject(userName);
    }
}
