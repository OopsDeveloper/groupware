package grpstudy.grpware.auth.security;

import grpstudy.grpware.auth.mapper.MemberMapper;
import grpstudy.grpware.common.utils.HashParameterMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HashParameterMap params = new HashParameterMap();
        params.setString("memberId", username);
        UserDetails memeberInfo = null;
        try {
            //내가 설정한 User 정보(VO)를 스프링이 제공하는 UserDetails를 변환 하기 위해서는 VO가 UserDetails를 구현하고 있어야 한다.
            memeberInfo = (UserDetails) this.memberMapper.read(params.getParameterMap());
        } catch (Exception e){
            e.printStackTrace();
        }
        return memeberInfo;
    }
}
