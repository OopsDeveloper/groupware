package grpstudy.grpware.login.mapper;

import grpstudy.grpware.login.domain.MemberVO;

public interface MemberMapper {
    public MemberVO read(String memberId);
}
