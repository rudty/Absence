package org.rudtyz.absence.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rudtyz.absence.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    void addMember() {
        Member m = new Member();
        m.setNickname("nick");
        m.setUserId("test01");
        memberService.addMember(m);
    }

    @Test
    void findAllMember() {
        Member m = new Member();
        m.setNickname("nick");
        m.setUserId("test01");
        memberService.addMember(m);

        List<Member> l = memberService.findAllMember();
        Assertions.assertEquals(l.size(), 1);
    }
}
