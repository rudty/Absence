package org.rudtyz.absence.service;

import org.rudtyz.absence.model.Member;
import org.rudtyz.absence.repository.MemberRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void addMember(Member m) {
        memberRepository.saveAndFlush(m);
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    public boolean exists(Member m) {
        return memberRepository.findById(m.getUserId()).isPresent();
    }
}
