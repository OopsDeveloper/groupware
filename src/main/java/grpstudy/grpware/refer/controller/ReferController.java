package grpstudy.grpware.refer.controller;

import grpstudy.grpware.common.utils.CommonUtils;
import grpstudy.grpware.refer.domain.ReferVO;
import grpstudy.grpware.refer.service.ReferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/refer")
public class ReferController {

    @Autowired
    private ReferService referService;

    // 자료실 글 목록
    @RequestMapping("/refer.do")
    public String getReferAll(Model model){

        model.addAttribute("referList", referService.getReferAll());

        return "refer/refer";
    }

    // 자료실 글 상세
    @GetMapping("/referView.do")
    public String getReferDetail(Model model, int referNo){
        model.addAttribute("refer", referService.getReferDetail(referNo));

        return "refer/referView";
    }

    // 자료실 글 등록 get
    @GetMapping("/referRegist.do")
    public String getReferRegist(Model model){
        model.addAttribute("loginId", CommonUtils.getLoginId());

        return "refer/referRegist";
    }

    // 자료실 글 등록 post
    @PostMapping("/reviewRegist.do")
    public String postReferRegist(ReferVO referVO){
        System.out.println("referVO : " + referVO);

        int cnt = referService.setRefer(referVO);

        return "redirect:/refer/refer.do";
    }

    // 자료실 수정 화면
    @GetMapping("/referModify.do")
    public String getReferModify(int referNo, Model model){
        model.addAttribute("refer", referService.getReferDetail(referNo));

        return "refer/referModify";
    }
    // 자료실 수정 내용
    @PostMapping("/referUpdate.do")
    public String postReferUpdate(ReferVO referVO, Model model){
        int cnt = referService.updateRefer(referVO);

        model.addAttribute("refer", referService.getReferDetail(referVO.getReferNo()));

        return "refer/referView";
    }

    // 자료실 글 삭제
    @RequestMapping("/referDelete.do")
    public String referDelete(int referNo, Model model){
        referService.deleteRefer(referNo);

        return "redirect:/refer/refer.do";
    }
}
