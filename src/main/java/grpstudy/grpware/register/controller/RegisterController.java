package grpstudy.grpware.register.controller;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Member;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @GetMapping("/registerWrite.do")
    public void registerWrite(){}

    @GetMapping("/memberIdCheck.do")
    @ResponseBody
    public MemberVO memberIdCheck(@RequestParam("memberId") String memberId){
        return registerService.registerMemberIdCheck(memberId);
    }
}
