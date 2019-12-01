package org.rudtyz.absence.service;

import org.junit.jupiter.api.Test;
import org.rudtyz.absence.model.Absence;
import org.rudtyz.absence.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class AbsenceServiceTest {
    @Autowired
    AbsenceService absenceService;

    @Autowired
    MemberService memberService;

    @Test
    void addAbsence() {
        Member m = new Member();
        m.setNickname("nick");
        m.setUserId("test01");
        memberService.addMember(m);

        Calendar calendar = Calendar.getInstance();

        calendar.set(2019, Calendar.JANUARY, 1, 12, 0);
        Date beginDate = calendar.getTime();

        calendar.set(2019, Calendar.JANUARY, 1, 13, 0);
        Date endDate = calendar.getTime();
        absenceService.addAbsence(new Absence(beginDate, endDate, m));
    }

    @Test
    void addAllAbsence() {
        Member m = new Member();
        m.setNickname("nick");
        m.setUserId("test01");
        memberService.addMember(m);

        Calendar calendar = Calendar.getInstance();

        calendar.set(2019, Calendar.JANUARY, 1, 12, 0);
        Date beginDate = calendar.getTime();

        calendar.set(2019, Calendar.JANUARY, 1, 13, 0);
        Date endDate = calendar.getTime();

        absenceService.addAllAbsence(beginDate, endDate);
    }
}
