package com.example.demo.Cntroller;

import com.example.demo.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserCntroller {

    private final UserSarvice userSarvice;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        List<User>userList=userSarvice.getAllUser();

        return ResponseEntity.status(200).body(userList);

    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        userSarvice.addUser(user);
        return ResponseEntity.status(200).body("user add");
    }
    @PutMapping("/update/{id}")
            public ResponseEntity updateUser(@Valid @RequestBody User user,@PathVariable Integer id ,Errors errors) {

        if (errors.hasErrors()) {
         String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("message");
        }
        boolean isupdate=userSarvice.updateUser(id,user);
        if (isupdate){
            return ResponseEntity.status(200).body("user update");
        }
        return ResponseEntity.status(400).body("user not found");
    }

    }

