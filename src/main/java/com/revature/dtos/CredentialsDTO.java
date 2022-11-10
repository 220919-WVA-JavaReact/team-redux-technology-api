package com.revature.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CredentialsDTO implements Serializable {
    private String username;
    private String password;
}
