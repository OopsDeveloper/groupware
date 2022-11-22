package grpstudy.grpware.register.service;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.register.mapper.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public int registerMemberIdCheck(String memberId) {
        return registerMapper.registerMemberIdCheck(memberId);
    }

    @Override
    public boolean registerMember(MemberVO memberVO) {
        //암호화
        memberVO.setMemberPw(passwordEncoder.encode(memberVO.getMemberPw()));
        int count = registerMapper.registerMember(memberVO);
        //인증테이블추가
        if(count == 1){
            registerMapper.registerMemberAuth(memberVO);
        }

        return count == 1;
    }
}
