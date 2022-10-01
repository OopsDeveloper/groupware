package grpstudy.grpware.notice.controller;

import grpstudy.grpware.notice.domain.NoticeVO;
import grpstudy.grpware.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/notice.do")
    public String notice(Model model) {

        model.addAttribute("noticeList", noticeService.getNoticeAll());
        return "notice/notice";
    }

    @RequestMapping("/noticeView.do")
    public String noticeView(int bno, Model model){

        model.addAttribute("notice",noticeService.getNotice(bno));
        return "notice/noticeView";
    }

    @GetMapping("/noticeRegist.do")
    public String getNoticeRegist(){
        return "notice/noticeRegist";
    }

    @PostMapping("/noticeRegist.do")
    public String postNoticeRegist(NoticeVO noticeVO){
        System.out.println("noticeVO = " + noticeVO);
        return "";
    }

}

