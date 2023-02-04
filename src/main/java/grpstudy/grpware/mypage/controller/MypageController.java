package grpstudy.grpware.mypage.controller;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.common.utils.CommonUtils;
import grpstudy.grpware.common.utils.HashParameterMap;
import grpstudy.grpware.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.ParameterMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/mypage")
@Slf4j
public class MypageController {
    @Autowired
    MemberService memberService;

    @GetMapping("/mypage.do")
    public void gotoMypage(Model model){
        HashParameterMap params = new HashParameterMap();
        params.setString("memberId", CommonUtils.getLoginId());
        MemberVO memberVO = memberService.read(params.getParameterMap());
        log.info("go to mypage");
        model.addAttribute("memberVO", memberVO);
    }
}
