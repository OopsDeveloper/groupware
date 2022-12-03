package grpstudy.grpware.member.service;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.auth.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public MemberVO read(Map<String, Object> params) {return memberMapper.read(params);}

    @Override
    public List<MemberVO> getMemberAll() {
        return memberMapper.getMemberAll();
    }

    @Override
    public int deleteMemebr(String id) {
        return memberMapper.deleteMember(id);
    }

    @Override
    public int updateAuth(String auth, String id) {
        return memberMapper.updateAuth(auth, id);
    }
}
