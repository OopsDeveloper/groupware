package grpstudy.grpware.mypage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
@Slf4j
public class MypageController {
    @GetMapping("/mypage.do")
    public void gotoMypage(){
        log.info("go to mypage");
    }
}
