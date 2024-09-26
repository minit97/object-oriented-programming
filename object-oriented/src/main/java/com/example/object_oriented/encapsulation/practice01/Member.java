package com.example.object_oriented.encapsulation.practice01;


import com.example.object_oriented.encapsulation.practice04.AlreadyVerifiedException;
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

    public void verifyEmail() throws AlreadyVerifiedException {
        if (isEmailVerified()) {
            throw new AlreadyVerifiedException();
        } else {
            this.verificationEmailStatus = 2;
        }
    }
}
