package com.hackathon.hypeapp.payload.Request;

import lombok.Data;

import java.util.Set;

@Data
public class UserReqDto {

    private String fullName;
    private String email;
    private String password;
    private Set<RoleDto> roleDtos;
}
