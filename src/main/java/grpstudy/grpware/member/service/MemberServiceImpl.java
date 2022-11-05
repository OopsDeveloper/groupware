package grpstudy.grpware.member.service;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.auth.mapper.MemberMapper;
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
