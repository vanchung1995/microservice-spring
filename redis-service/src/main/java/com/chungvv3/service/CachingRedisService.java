package com.chungvv3.service;

import com.chungvv3.entities.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CachingRedisService {
    private Map<String, User> userMap;

    @PostConstruct
    private void postConstruct() {
        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("user1", 18),
                new User("user2", 20),
                new User("user3", 22)
        ));
        userMap = userList.stream().collect(Collectors.toMap(elem -> elem.getName(), Function.identity()));    }

    @Cacheable(value = "users", key = "#key")
    public User getObject(String key) {
        System.out.println("Getting key: " + key);
        return userMap.get(key);
    }

    public void putObject(String key, String val) {

    }

    public void deleteKey(String key) {

    }
}
