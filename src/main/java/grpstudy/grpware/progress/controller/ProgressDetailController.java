package grpstudy.grpware.progress.controller;

import grpstudy.grpware.progress.service.ProgressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/progress")
public class ProgressDetailController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProgressService progressService;

    @RequestMapping("/progressDetail.do")
    public String progress() {
        return "progress/progressDetail";
    }

}

