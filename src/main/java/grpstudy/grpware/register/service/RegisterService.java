package grpstudy.grpware.register.service;

import grpstudy.grpware.auth.domain.MemberVO;

public interface RegisterService {
    MemberVO registerMemberIdCheck(String memberId);
}
