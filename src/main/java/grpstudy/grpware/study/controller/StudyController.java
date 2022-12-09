package grpstudy.grpware.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/study")
public class StudyController {

    @RequestMapping("/study.do")
    public String study() {
        return "study/study";
    }

}

