package com.revature.dtos;

import com.revature.utils.Role;
import lombok.Data;

@Data
public class UserDTO {
    private String Username;
    private String password;
    private Role role;
}
