package grpstudy.grpware.login.mapper;

import grpstudy.grpware.login.domain.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper {
    public MemberVO read(String memberId);
    public List<MemberVO> getMemberAll();
}
