package grpstudy.grpware.register.service;

import grpstudy.grpware.login.domain.MemberVO;

public interface RegisterService {
    MemberVO registerMemberIdCheck(String memberId);
}
