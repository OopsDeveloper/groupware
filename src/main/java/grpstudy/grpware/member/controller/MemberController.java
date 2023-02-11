package grpstudy.grpware.member.controller;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.common.utils.CommonUtils;
import grpstudy.grpware.common.utils.HashParameterMap;
import grpstudy.grpware.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @PostMapping("/deleteMemebr.do")
    public String deleteMember(HttpServletRequest request){
        memberService.deleteMemebr(request.getParameter("id"));

        return "redirect:/member/member.do";
    }

    @PostMapping("/updateAuth.do")
    public String updateAuth(HttpServletRequest request){
        String auth = request.getParameter("auth");
        String id = request.getParameter("id");
        memberService.updateAuth(auth,id);

        return "redirect:/member/member.do";
    }

    @GetMapping("/updateMember.do")
    public String getUpdateMember(Model model) {
        HashParameterMap params = new HashParameterMap();
        params.setString("memberId", CommonUtils.getLoginId());
        MemberVO memberVO = memberService.read(params.getParameterMap());
        model.addAttribute("memberVO", memberVO);

        return "mypage/updateMember";
    }

    @PostMapping("/updateMember.do")
    public String postUpdateMember(MemberVO memberVO){
        /*멤버 업데이트 하기*/
        return "redirect:/mypage/mypage.do";
    }
}

