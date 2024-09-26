package com.example.object_oriented.encapsulation.practice04;

import com.example.object_oriented.encapsulation.practice01.Member;

public class Service {

    public void verifyEmail(String token) throws BadTokenException, AlreadyVerifiedException {
        Member mem = findByToken(token);
        if (mem == null) throw new BadTokenException();

        mem.verifyEmail();

        // ... 수정사항 DB 반영
    }

    private Member findByToken(String token) {
        return null;
    }
}
