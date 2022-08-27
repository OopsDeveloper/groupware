package grpstudy.grpware.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        System.out.println("Login Success");

        List<String> roleNames = new ArrayList<>();

        auth.getAuthorities().forEach(autority -> {
            roleNames.add(autority.getAuthority());
        });

        System.out.println("roleNames : " + roleNames);

        if(roleNames.contains("ROLE_MEMBER")){
            response.sendRedirect("/main.do");
            return;
        }

        response.sendRedirect("/");
    }
}
