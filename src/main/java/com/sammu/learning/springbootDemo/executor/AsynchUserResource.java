package com.sammu.learning.springbootDemo.executor;

import com.sammu.learning.springbootDemo.mongo.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
@Slf4j
@RestController
public class AsynchUserResource {

    @Autowired
    UserService userService;

    @Operation(summary = "Create new User (Async)")
    @PostMapping("/v1/async/createuser")
    public CompletableFuture<ResponseEntity<User>> createUser(
            @RequestBody User user) throws InterruptedException {

        log.info("creating new user {}", user);

        return userService.createUser(user)
                .thenApply(ResponseEntity::ok);
    }
}
