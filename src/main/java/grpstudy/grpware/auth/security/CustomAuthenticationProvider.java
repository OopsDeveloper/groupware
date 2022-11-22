package grpstudy.grpware.auth.security;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.common.utils.HashParameterMap;
import grpstudy.grpware.common.utils.StringUtil;
import grpstudy.grpware.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자 인증 프로바이더
 *
 * @author KIMYONSEI
 * @since 2022. 11. 18
 * */
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    MemberService memberService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    PasswordEncoder encoder;

    /**사용자 인증 및 사용자 정보 Token에 담는다*/
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;

        String userId = authentication.getName();
        String userPw = (String) authentication.getCredentials();

        HashParameterMap params = new HashParameterMap();

        //1. ID 또는 비밀번호가 입력되었는지 확인
        if ( StringUtil.isEmpty(userId) || StringUtil.isEmpty(userPw) ) {
            throw new InsufficientAuthenticationException("인증정보가 없어 인증에 실패했습니다. 관리자에게 문의하세요. (customAuthenticationProvider)");
        }

        //사용자 정보 가져오기
        UserDetails memberVO = customUserDetailsService.loadUserByUsername(authToken.getName());

        //2. ID에 맞는 사용자가 있는지 확인
        if(memberVO == null) {
            throw new BadCredentialsException("해당 아이디 정보가 존재하지 않습니다. 입력하신 아이디를 확인하세요.");
        }

        //3.패스워드가 맞는지 확인
        //matches(입력된 비밀번호, 저장된 비밀번호 체크
        boolean matchPw = encoder.matches(userPw, memberVO.getPassword());
        if( !matchPw ){
            throw new BadCredentialsException("비밀번호가 틀렸습니다. 입력하신 아이디와 비밀번호를 확인하세요.");
        }

        List<GrantedAuthority> authorities = (List<GrantedAuthority>) memberVO.getAuthorities();
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(memberVO.getUsername(),memberVO.getPassword(), authorities);

        return token;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class<?> authentication) {
        return VALIDE_TOKEN_CLASS.isAssignableFrom(authentication);
    }

    @SuppressWarnings("rawtypes")
    private static final Class VALIDE_TOKEN_CLASS = UsernamePasswordAuthenticationToken.class;
}
