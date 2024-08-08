package com.ITsupport.support.App.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
}
