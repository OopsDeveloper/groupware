package grpstudy.grpware.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UploadController {

    @PostMapping("/uploadAjax")
    public void uploadAjax(){

        log.info("File upload by ajax");
    }
}
