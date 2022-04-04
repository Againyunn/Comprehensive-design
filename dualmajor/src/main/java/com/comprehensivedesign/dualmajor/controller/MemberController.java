package com.comprehensivedesign.dualmajor.controller;

import com.comprehensivedesign.dualmajor.Service.MemberService;
import com.comprehensivedesign.dualmajor.domain.Member;
import com.comprehensivedesign.dualmajor.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @GetMapping("/member")
    @ResponseBody
    public String member() {
        return "member page";
    }
    /*============================*/


    @PostMapping("/checkJoinedEmail") //email 입력받은 후 가입된 회원인지 확인
    //비밀번호 찾기 기능중 회원 확인 절차용
    public Map chekcJoinedMember(@RequestBody MemberDto memberDto) {
        HashMap<String, Object> map = new HashMap<>();
        Member member = memberService.find(memberDto.getEmail());
        if (member == null) {
            map.put("joinedMember", false);
        }
        else{
            map.put("joinMember", true);
            map.put("email",member.getEmail());
        }
        return map;
    }

    @PostMapping("/editInfo")
    public Map editMember(@RequestBody MemberDto memberDto) {
        Member updatedMember = memberService.update(memberDto);
        MemberDto updatedMemberDto = new MemberDto();
        updatedMemberDto.setLoginInfo(
                updatedMember.getName(),
                updatedMember.getStdNum(),
                updatedMember.getFirstMajor(),
                updatedMember.getDualMajor(),
                updatedMember.getGrade(),
                updatedMember.getType());
        return updatedMemberDto.getLoginInfo(); //업데이트 성공 후 업데이트된 데이터 셋 반환
    }
}
