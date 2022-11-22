package grpstudy.grpware.register.service;

import grpstudy.grpware.auth.domain.MemberVO;

public interface RegisterService {
    int registerMemberIdCheck(String memberId);

    boolean registerMember(MemberVO memberVO);
}
