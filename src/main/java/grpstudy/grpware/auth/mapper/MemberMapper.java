package grpstudy.grpware.auth.mapper;

import grpstudy.grpware.auth.domain.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper {
    public MemberVO read(String memberId);
    public List<MemberVO> getMemberAll();
}
