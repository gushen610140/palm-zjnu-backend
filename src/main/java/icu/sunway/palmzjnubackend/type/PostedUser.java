package icu.sunway.palmzjnubackend.type;

import lombok.Data;

@Data
public class PostedUser {
    private String username;
    private String password;
    private String phone;
    private String email;
}
