package grpstudy.grpware.register.controller;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Member;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @GetMapping("/registerWrite.do")
    public void registerWrite() {
    }

    @PostMapping("/registerWrite.do")
    public String registerMember(MemberVO memberVO, RedirectAttributes redirectAttributes){
        boolean successProcess = registerService.registerMember(memberVO);
        redirectAttributes.addFlashAttribute("memberId", memberVO.getMemberId());
        return "redirect:/auth/login.do";
    }

    @GetMapping("/memberIdCheck.do")
    @ResponseBody
    public boolean memberIdCheck(@RequestParam("memberId") String memberId) {
        int memberCnt = registerService.registerMemberIdCheck(memberId);
        return memberCnt < 1;
    }
}
