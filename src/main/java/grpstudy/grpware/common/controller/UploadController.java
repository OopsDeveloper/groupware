package grpstudy.grpware.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Controller
@Slf4j
@RequestMapping("/upload")
public class UploadController {
    //파일경로
    @Value("${file.path}")
    private String uploadPath;

    @PostMapping("/ajax.do")
    public void uploadAjax(MultipartFile[] uploadFile){
        log.info("File upload by ajax");

        for (MultipartFile multipartFile : uploadFile) {
            String uploadFileName = multipartFile.getOriginalFilename();
            //IE 호환조치
            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);

            File saveFile = new File(uploadPath, uploadFileName);

            try{
                multipartFile.transferTo(saveFile);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("파일 업로드 과정에서 문제가 생겼습니다.");
            }
        }
    }
}
