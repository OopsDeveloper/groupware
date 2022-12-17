package grpstudy.grpware.register.service;

import grpstudy.grpware.auth.domain.MemberVO;

import java.util.Map;

public interface RegisterService {
    int registerMemberIdCheck(Map<String, Object> params);

    boolean registerMember(MemberVO memberVO);

    void updateMemberPw(Map<String, Object> params);
}
