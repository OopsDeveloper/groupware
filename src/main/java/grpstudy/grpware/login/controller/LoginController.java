package grpstudy.grpware.login.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/*")
public class LoginController {
    //접근 권한이 없는 경우
    @GetMapping("/accessError.do")
    public void accessError(Authentication auth, Model model){
        model.addAttribute("msg", "접근 권한이 없습니다. 관리자에게 문의해주시기 바랍니다.");
    }

    //시큐리티 로그인 페이지 이동
    @GetMapping("/login.do")
    public void loginGET(String error, String logout, Model model){
        if(error != null){
            model.addAttribute("error", "아이디와 비밀번호를 확인해주시기 바랍니다.");
        }
        if(logout != null){
            model.addAttribute("logout", "로그아웃되었습니다.");
        }
    }

    //시큐리티 로그아웃
    @PostMapping("/logout.do")
    public void logoutPOST(){
        System.out.println("Logout.........");
    }
}
