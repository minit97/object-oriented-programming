package com.example.object_oriented.encapsulation.practice01;

public class PraticeService {


    private PasswordEncode passwordEncode;

    public AuthResult authenticate(String id, String pw) {
        Member mem = findOne(id);
        if (mem == null) return AuthResult.NO_MATCH;

        if (!mem.isEmailVerified()) {
            return AuthResult.NO_EMAIL_VERIFIED;
        }

        if (passwordEncode.isPasswordValid(mem.getPassword(), pw, mem.getId())) {
            return AuthResult.SUCCESS;
        }
        return AuthResult.NO_MATCH;
    }

    private Member findOne(String id) {
        return null;
    }

}
