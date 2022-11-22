package grpstudy.grpware.auth.security;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 로그아웃 핸들러
 * @author KIMYONSEI
 * @since 2022. 11. 18
 * */
@Slf4j
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
       log.info("커스텀 로그아웃 핸들러");
       String redirectUrl = "/auth/login.do?logout=true";
       log.info("redirectUrl : " + redirectUrl);
       httpServletResponse.sendRedirect(redirectUrl);
    }
}
