package grpstudy.grpware.member.controller;

import grpstudy.grpware.login.domain.MemberVO;
import grpstudy.grpware.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/member.do")
    public String notice(Model model) {
        List<MemberVO> memberList = memberService.getMemberAll();
        model.addAttribute("memberList", memberList);

        return "member/member";
    }
}

