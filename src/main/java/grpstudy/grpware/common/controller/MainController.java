package grpstudy.grpware.common.controller;

import grpstudy.grpware.common.utils.CommonUtils;
import grpstudy.grpware.place.domain.PlaceVO;
import grpstudy.grpware.place.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/main.do")
    public void main(Model model){
        String loginId = CommonUtils.getLoginId();
        boolean chk = CommonUtils.isAdmin();

        PlaceVO vo = placeService.getPlace();
        model.addAttribute("place",vo);
        model.addAttribute("loginId",loginId);
        model.addAttribute("adminChk",chk);
    }
}
