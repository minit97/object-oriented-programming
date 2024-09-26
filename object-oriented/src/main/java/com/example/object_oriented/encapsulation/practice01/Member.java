package com.example.object_oriented.encapsulation.practice01;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id;
    private String password;
    private int verificationEmailStatus;

    public boolean isEmailVerified() {
        return verificationEmailStatus == 2;
    }
}
