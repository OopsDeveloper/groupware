package grpstudy.grpware.progress.controller;

import grpstudy.grpware.progress.service.ProgressService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/progress")
public class ProgressController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProgressService progressService;

    @RequestMapping("/progress.do")
    public String progress() {
        return "progress/progress";
    }

    @ResponseBody
    @RequestMapping("/selectProgressRate.do")
    public Map<String,Object> selectProgressRate() throws Exception {
        //Map<String,Object> resultObj = progressService.selectProgressRate();
        Map<String,Object> resultObj = null;
        return resultObj;
    }

}

