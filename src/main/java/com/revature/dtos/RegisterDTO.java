package com.revature.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.revature.entities.User;
@Data
@Getter @Setter
public class RegisterDTO {
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;

    public  RegisterDTO(User user){
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
