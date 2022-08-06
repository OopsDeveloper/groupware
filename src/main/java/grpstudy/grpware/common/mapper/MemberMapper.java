package grpstudy.grpware.common.mapper;

import grpstudy.grpware.common.domain.MemberVO;

public interface MemberMapper {
    public MemberVO read(String memberId);
}
