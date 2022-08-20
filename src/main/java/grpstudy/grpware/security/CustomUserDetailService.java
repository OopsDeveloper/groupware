package grpstudy.grpware.security;

import grpstudy.grpware.login.domain.CustomUser;
import grpstudy.grpware.login.domain.MemberVO;
import grpstudy.grpware.login.mapper.MemberMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Setter(onMethod_ = @Autowired)
    private MemberMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("Load User By UserName : " + userName);

        MemberVO vo = mapper.read(userName);

        System.out.println("queried by member mapper : " + vo);

        return vo == null ? null : new CustomUser(vo);
    }
}
