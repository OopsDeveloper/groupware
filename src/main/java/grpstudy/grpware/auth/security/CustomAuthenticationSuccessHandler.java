package grpstudy.grpware.auth.security;

import grpstudy.grpware.auth.domain.CustomUser;
import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.common.utils.HashParameterMap;
import grpstudy.grpware.common.utils.StringUtil;
import grpstudy.grpware.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * CustomAuthenticationProvider에서 토큰을 이쪽으로 넘겨줘서 CustomAuthenticationSuccessHandler 역할을 해주는 것 같음
 * 로그인 성공 후 특정한 동작을 하도록 제어하는 곳
 * */
@Slf4j
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
    @Autowired
    MemberService memberService;

    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String userId = authentication.getName();
        HashParameterMap params = new HashParameterMap();

        //사용자 정보
        params.setString("memberId", userId);
        MemberVO details = this.memberService.read(params.getParameterMap());

        //접근 IP 조회 및 저장
        String userIpAddress = httpServletRequest.getHeader("X-FORWARDED-FOM");
        if(StringUtil.isEmpty(userIpAddress)){
            userIpAddress = httpServletRequest.getRemoteAddr();
        }
        details.setLoginIpAddress(userIpAddress);

        //헤더정보 문자화 및 저장
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        String headers = "";
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            headers += name + " : " + httpServletRequest.getHeader(name) + ", ";
        }
        details.setHeaders(headers);

        //authToken에 userDetail 추가
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        token.setDetails(details);

        HttpSession session = httpServletRequest.getSession();
        DefaultSavedRequest savedRequest = (DefaultSavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");

//        boolean accessSuccess = memberVO.getAuthList().stream().anyMatch(auth -> auth == "ROLE_MEMBER");
////        boolean accessDenied = token.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority() == "ROLE_MEMBER");
//
//        if(!accessSuccess){
//            httpServletResponse.sendRedirect("/auth/login.do?accessDenied");
//        } else {
            httpServletResponse.sendRedirect("/main.do");
//        }
    }

}
