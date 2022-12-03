package grpstudy.grpware.auth.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
/**
 * ************사용안함*************
 * 로그인 사용자 정보
 * UserDetails를 구현해서 사용
 * */
public class CustomUser implements UserDetails {
    /**UID*/
    private static final long serialVersionUID = 1L;
    /**사용자 정보*/
    private MemberVO memberVO;
    /**로그인IP*/
    private String loginIpAddress;
    /**request헤더문자열*/
    private String headers;
    /**접속중인 로그인ID*/
    public String getUserId(){
        return memberVO.getMemberId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> grantedAuths = null;
//        memberVO.getAuthList().stream().forEach(authVO -> grantedAuths.add((GrantedAuthority) authVO.getAuthAuth()));
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public MemberVO getMemberVO() {
        return memberVO;
    }

    public void setMemberVO(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    public String getLoginIpAddress() {
        return loginIpAddress;
    }

    public void setLoginIpAddress(String loginIpAddress) {
        this.loginIpAddress = loginIpAddress;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }
}
