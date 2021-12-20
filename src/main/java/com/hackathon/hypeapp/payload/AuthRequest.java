package com.hackathon.hypeapp.payload;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
