package grpstudy.grpware.common.controller;

import grpstudy.grpware.common.service.SampleService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common/*")
public class CommonController {
    //테스트 메서드
    @Setter(onMethod_ = @Autowired)
    SampleService service;

    @GetMapping("/sample.html")
    public void test(){

    }

    @GetMapping("/sampleRead.html")
    public void sampleRead(Model model){
        model.addAttribute("sampleVO", service.read());
    }

    //실제 사용 메서드

    //접근 권한이 없는 경우
    @GetMapping("/accessError.html")
    public void accessError(Authentication auth, Model model){
        model.addAttribute("msg", "접근 권한이 없습니다. 관리자에게 문의해주시기 바랍니다.");
    }

    //시큐리티 로그인 페이지 이동
    @GetMapping("/login.html")
    public void loginGET(String error, String logout, Model model){
        if(error != null){
            model.addAttribute("error", "아이디와 비밀번호를 확인해주시기 바랍니다.");
        }
        if(logout != null){
            model.addAttribute("logout", "로그아웃되었습니다.");
        }
    }

    //시큐리티 로그아웃 페이지 이동
    @GetMapping("/logout.html")
    public void logoutGET(){

    }
    //시큐리티 로그아웃 페이지 이동
    @PostMapping("/logout.html")
    public void logoutPOST(){

    }


}
