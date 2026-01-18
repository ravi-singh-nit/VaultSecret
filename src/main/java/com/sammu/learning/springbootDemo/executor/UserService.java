package com.sammu.learning.springbootDemo.executor;

import com.sammu.learning.springbootDemo.mongo.User;
import com.sammu.learning.springbootDemo.mongo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Async("appExecutor")
    public CompletableFuture<User> createUser(User user) throws InterruptedException {
        // simulate work
        Thread.sleep(2000);
        return CompletableFuture.completedFuture(userRepository.save(user));
    }
  // run from  terminal
//  for i in {1..30}
//do
//    curl -X POST http://localhost:8080/v1/async/createuser \
//            -H "Content-Type: application/json" \
//            -d '{"id":'$i',"name":"user'$i'","email":"u'$i'@test.com"}' &
//    done
}

