package grpstudy.grpware.register.mapper;

import grpstudy.grpware.auth.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface RegisterMapper {
    int registerMemberIdCheck(Map<String, Object> params);

    int registerMember(MemberVO memberVO);

    int registerMemberAuth(MemberVO memberVO);

    void updateMemberPw(Map<String, Object> params);
}
