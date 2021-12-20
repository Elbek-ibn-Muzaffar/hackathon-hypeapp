package com.hackathon.hypeapp.services;


import com.hackathon.hypeapp.entity.RoleEntity;
import com.hackathon.hypeapp.payload.Request.RoleDto;
import com.hackathon.hypeapp.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    ModelMapper modelMapper=new ModelMapper();

    public String saveRole(RoleDto roleDto)
    {

        roleRepository.save(modelMapper.map(roleDto,RoleEntity.class));
        return "Saqlandi";
    }
}
