package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can't be empty")
    @Column(columnDefinition ="varbinary (4) not null ")
    private String name;

    @NotEmpty
    @Column(columnDefinition = "varbinary (4) not null  unique ,")
    private String username;

    @NotEmpty
    @Column(columnDefinition = "varbinary(10) not null")
    private  String password;

    @NotEmpty
    @Column(columnDefinition = " varbinary(15)not null unique ")
    private  String email;

    @NotEmpty
    @Column(columnDefinition = "varbinary(10)not null check ( role='User' or 'Admin')")
    private String role;

    @NotNull
    @Column(columnDefinition = " int not null")
    private Integer age;

}
