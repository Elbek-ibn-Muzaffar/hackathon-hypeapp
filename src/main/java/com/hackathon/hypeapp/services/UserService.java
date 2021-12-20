package com.hackathon.hypeapp.services;

import com.hackathon.hypeapp.entity.UserEntity;
import com.hackathon.hypeapp.payload.Request.UserReqDto;
import com.hackathon.hypeapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    ModelMapper modelMapper=new ModelMapper();

    @Autowired
    private PasswordEncoder passwordEncoder;

    //saving user
    public String saveUser(UserReqDto userDto)
    {
        if (!userRepository.existsByEmail(userDto.getEmail()))
        {
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(modelMapper.map(userDto, UserEntity.class));
            return "Saqlandi";
        }

        return "Bu User mavjud";
    }


}
