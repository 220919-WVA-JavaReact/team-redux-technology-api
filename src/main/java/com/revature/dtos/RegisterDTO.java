package com.revature.dtos;

import lombok.Data;

@Data
public class RegisterDTO {
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;

}
