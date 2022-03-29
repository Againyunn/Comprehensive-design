package com.comprehensivedesign.dualmajor.Service;

import com.comprehensivedesign.dualmajor.domain.Member;
import java.util.Optional;
import com.comprehensivedesign.dualmajor.dto.MemberDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface MemberService {
    //회원가입
    Long join(MemberDto memberDto) throws Exception;
    UserDetails login(String stdNum, String password) throws Exception;
    Member find(String email);

    Member findById(Long id);
}
