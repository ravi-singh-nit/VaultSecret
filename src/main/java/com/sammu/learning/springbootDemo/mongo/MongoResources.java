package com.sammu.learning.springbootDemo.mongo;



import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@Slf4j
@RestController
@Tag(name="Mongo Crud Resources")
public class MongoResources {

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "Get user by ID")
    @GetMapping("/v1/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        log.info("Fetching request for userID {}", id);
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get All Users")
    @GetMapping("/v1/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Create new User")
    @PostMapping("/v1/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        log.info("creating new user ", user);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @Operation(summary = "Delete user by Id")
    @DeleteMapping("v1/deleteUser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id){
        log.info("Request for deleting user idv {}",id);
        if(userRepository.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/users")
    public ResponseEntity<Page<User>> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String sort) {

        String[] sortParams = sort.split(",");
        Sort sortObj = Sort.by(
                Sort.Direction.fromString(sortParams[1]),
                sortParams[0]
        );

        Pageable pageable = PageRequest.of(page, size, sortObj);

        Page<User> users = userRepository.findAll(pageable);

        return ResponseEntity.ok(users);
    }


}
