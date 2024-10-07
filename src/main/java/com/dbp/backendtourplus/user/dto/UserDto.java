package com.dbp.backendtourplus.user.dto;


import com.dbp.backendtourplus.user.domain.Role;
import lombok.Data;

@Data
public class UserDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
    private String rolePrefix;
}
