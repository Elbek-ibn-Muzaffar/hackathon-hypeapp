package com.hackathon.hypeapp.entity;

import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;

    private String fullname;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "name", referencedColumnName = "name")}
    )
    private Set<RoleEntity> roleEntities;


}
