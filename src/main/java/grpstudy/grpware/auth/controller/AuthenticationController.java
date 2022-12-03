package grpstudy.grpware.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @RequestMapping("/login.do")
    public String forwardLoginPage(String logout, String error, String accessDenied, Model model){
        log.info("request : /auth/login.do -> /auth/login.jsp");
        if(error != null){
            model.addAttribute("error", "아이디 혹은 비밀번호 오류입니다.");
        }
        if(logout != null){
            model.addAttribute("logout", "로그아웃이 완료되었습니다.");
        }
        if(accessDenied != null){
            model.addAttribute("accessDenied", "접근 권한이 없습니다. 관리자에게 문의하세요.");
        }
        return "/auth/login";
    }

    @GetMapping("/forgotPw.do")
    public String forwardForgotPwPage(){
        log.info("/auth/forgotPw.do");
        return "/auth/forgotPw";
    }
}
