package com.chungvv3.service;

import com.chungvv3.entities.User;
import com.chungvv3.exception.CustomUserNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UserService {
    private final static int INIT_SIZE = 10;
    List<User> USERS;

    @PostConstruct
    private void postConstruct() {
        USERS = IntStream.range(0, INIT_SIZE).map(num -> num + 1)
                .mapToObj(num -> new User(num, "User-" + num, LocalDate.now().minusYears(getRandomInt(15, 30))))
                .collect(Collectors.toList());
    }

    private int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public List<User> getAllUsers() {
        return USERS;
    }

    public User getUser(int userId) {
        Optional<User> optional = USERS.stream().filter(user -> user.getId() == userId).findFirst();
        if (optional.isEmpty()) throw new CustomUserNotFoundException("User with id " + userId + " not found!");
        return optional.get();
    }

    public User addUser(User user) {
        user.setId(USERS.size() + 1);
        USERS.add(user);
        return user;
    }

    public void delete(int userId) {
        USERS.removeIf(user -> user.getId() == userId);
    }
}
