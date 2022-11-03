package com.revature.dtos;

import com.revature.entities.User;
import com.revature.utils.Role;
import lombok.Data;

@Data
public class UserDTO {
    private String user_id;
    private String username;
    private Role role;

    public UserDTO(User user){
        this.user_id = user.getUser_id();
        this.username = user.getUsername();
        this.role = user.getRole();
    }
}
