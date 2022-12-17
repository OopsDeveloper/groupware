package grpstudy.grpware.progress.controller;

import grpstudy.grpware.progress.service.ProgressService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/progress")
public class ProgressDetailController {

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProgressService progressService;

    @RequestMapping("/progressDetail.do")
    public String progress(Model model) throws Exception {
        model.addAttribute("studyList",progressService.selectStudyList());
        log.info("progress");
        return "progress/progressDetail";
    }

    @ResponseBody
    @RequestMapping(value = "/progressDetailListAjax.do")
    public Map<String, Object> progressDetailListAjax(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String,Object> map, Model model) throws Exception {
        HashMap<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("result", progressService.selectStudyDetailList(map));
        return paramMap;
    }

}

