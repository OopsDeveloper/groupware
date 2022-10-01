package grpstudy.grpware.progress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/progress")
public class ProgressController {
    @RequestMapping("/progress.do")
    public String progress() {
        return "progress/progress";
    }

}

