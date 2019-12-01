package org.rudtyz.absence.controller;

import com.fasterxml.jackson.annotation.JsonRawValue;
import org.rudtyz.absence.model.Member;
import org.rudtyz.absence.service.MemberService;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @JsonRawValue
    private static final String returnMsgOK = "{\"msg\":\"OK\"}";

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(value = "/add")
    String addMember(@Valid Member member, BindingResult result) throws BindException {
        if (result.hasErrors()) {
            throw new BindException(result);
        }

        memberService.addMember(member);
        return returnMsgOK;
    }

    @GetMapping("")
    List<Member> getMembers() {
        return memberService.findAllMember();
    }
}
