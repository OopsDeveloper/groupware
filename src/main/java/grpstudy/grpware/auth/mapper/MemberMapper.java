package grpstudy.grpware.auth.mapper;

import grpstudy.grpware.auth.domain.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MemberMapper {
    public MemberVO read(Map<String, Object> params);
    public List<MemberVO> getMemberAll();
}
