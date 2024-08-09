package com.ITsupport.support.App.auth;

import com.ITsupport.support.App.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {


    private String email;
    private String username;
    private String password;
    private Role role;
}
