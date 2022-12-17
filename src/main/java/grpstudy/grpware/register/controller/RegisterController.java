package grpstudy.grpware.register.controller;

import grpstudy.grpware.auth.domain.MemberVO;

import grpstudy.grpware.common.utils.CommonUtils;
import grpstudy.grpware.common.utils.HashParameterMap;
import grpstudy.grpware.register.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @GetMapping("/registerWrite.do")
    public void registerWrite() {
    }

    @PostMapping("/registerWrite.do")
    public String registerMember(MemberVO memberVO, RedirectAttributes redirectAttributes) {
        boolean successProcess = registerService.registerMember(memberVO);
        if (successProcess) {
            redirectAttributes.addFlashAttribute("memberId", memberVO.getMemberId());
        }
        return "redirect:/auth/login.do";
    }

    @GetMapping("/memberIdCheck.do")
    @ResponseBody
    public boolean memberIdCheck(HttpServletRequest request) {
        HashParameterMap params = CommonUtils.setRequestParameterMap();
        int memberCnt = registerService.registerMemberIdCheck(params.getParameterMap());
        return memberCnt < 1;
    }

    @PostMapping("/resetPw.do")
    @ResponseBody
    public void resetPassword(HttpServletRequest request) {
        HashParameterMap params = CommonUtils.setRequestParameterMap();
        registerService.updateMemberPw(params.getParameterMap());
    }
}
