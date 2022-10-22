package grpstudy.grpware.register.service;

import grpstudy.grpware.login.domain.MemberVO;
import grpstudy.grpware.register.mapper.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;

    @Override
    public MemberVO registerMemberIdCheck(String memberId) {
        return registerMapper.registerMemberIdCheck(memberId);
    }
}
