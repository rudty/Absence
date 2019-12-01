package org.rudtyz.absence.service;

import org.rudtyz.absence.model.Absence;
import org.rudtyz.absence.model.Member;
import org.rudtyz.absence.repository.AbsenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbsenceService {
   private final MemberService memberService;
   private final AbsenceRepository absenceRepository;

   public AbsenceService(MemberService memberService, AbsenceRepository absenceRepository) {
       this.memberService = memberService;
       this.absenceRepository = absenceRepository;
   }

   @Transactional
   public void addAbsence(Absence absence) {
        if (!memberService.exists(absence.getMember())) {
            throw new RuntimeException("register member first");
//            memberService.addMember(absence.getMember());
        }
        absenceRepository.save(absence);
   }

    /**
     * 모든 멤버에 대해서 등록함
     * 등록전 먼저
     * 한명이라도 부재가 있는지 검사하고
     * 있다면 오류
     *
     * @param beginDate 시작날짜
     * @param endDate 끝 날짜
     */
    @Transactional
    public void addAllAbsence(final Date beginDate, final Date endDate) {
        absenceRepository
                .findAbsenceByBeginDateAndEndDate(beginDate, endDate)
                .ifPresent(member -> { throw new RuntimeException(member.getMember().getUserId() + " has absence"); });

        final List<Absence> a = memberService
                .findAllMember()
                .stream()
                .map(member -> new Absence(beginDate, endDate, member))
                .collect(Collectors.toList());

        absenceRepository.saveAll(a);
    }

}
