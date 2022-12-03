package grpstudy.grpware.auth.mapper;

import grpstudy.grpware.auth.domain.MemberVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MemberMapper {
    public MemberVO read(Map<String, Object> params);
    public List<MemberVO> getMemberAll();
    public int deleteMember(String id);
    public int updateAuth(@Param("auth") String auth, @Param("id") String id);
}
