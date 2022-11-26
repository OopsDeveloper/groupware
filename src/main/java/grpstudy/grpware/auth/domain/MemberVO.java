package grpstudy.grpware.auth.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Alias("memberVO")
public class MemberVO implements UserDetails {
    private String memberNo;
    private String memberNm;
    private String memberId;
    private String memberPw;
    private String memberBirth;
    private String memberMail;
    private String memberPhone;

    /**인증정보*/
    private List<AuthVO> authList;
    /**로그인 IP*/
    private String loginIpAddress;
    /**request헤더문자열*/
    private String headers;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.authList.stream().forEach(authVO -> {
            authorities.add(new SimpleGrantedAuthority(authVO.getAuthAuth()));
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.memberPw;
    }

    @Override
    public String getUsername() {
        return this.memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
