package grpstudy.grpware.member.service;

import grpstudy.grpware.login.domain.MemberVO;
import grpstudy.grpware.login.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<MemberVO> getMemberAll() {
        return memberMapper.getMemberAll();
    }
}
