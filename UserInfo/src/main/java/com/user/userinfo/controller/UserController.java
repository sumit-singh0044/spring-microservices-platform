package com.user.userinfo.controller;




import com.user.userinfo.entity.Users;
import com.user.userinfo.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    public UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Users user=userService.getUserById(id);

        if(user==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(user);
    }

//    @PostMapping
//    public ResponseEntity<Void> saveUser(@RequestBody Users user) {
//        Users savedUser = userService.saveUser(user);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
        Users savedUser = userService.saveUser(user);

        if(savedUser==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable Long id) {
        Users user=userService.getUserById(id);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteById(id);
        return ResponseEntity.ok(user);
    }

}
