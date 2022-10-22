package grpstudy.grpware.register.mapper;

import grpstudy.grpware.login.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    MemberVO registerMemberIdCheck(String memberId);
}
