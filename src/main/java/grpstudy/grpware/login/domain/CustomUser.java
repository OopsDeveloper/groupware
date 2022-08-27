package grpstudy.grpware.login.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUser extends User {
    private static final long serialVersionUID = 1L;

    private MemberVO member;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);
    }

    public CustomUser(MemberVO vo){
        super(vo.getMemberId(), vo.getMemberPw(), vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuthAuth())).collect(Collectors.toList()));

        this.member = vo;
    }
}
