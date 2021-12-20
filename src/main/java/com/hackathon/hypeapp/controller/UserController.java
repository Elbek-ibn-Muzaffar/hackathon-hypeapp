package com.hackathon.hypeapp.controller;


import com.hackathon.hypeapp.payload.Request.UserReqDto;
import com.hackathon.hypeapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity saveUsers(@RequestBody UserReqDto userDto)
    {
        return ResponseEntity.ok(userService.saveUser(userDto));
    }
}
