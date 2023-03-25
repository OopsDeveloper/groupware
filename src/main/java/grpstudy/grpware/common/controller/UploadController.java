package grpstudy.grpware.common.controller;

import grpstudy.grpware.common.domain.AttachFileVO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/upload")
public class UploadController {
    //파일경로
    @Value("${file.path}")
    private String uploadPath;

    @PostMapping(value = "/ajax.do", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<AttachFileVO>> uploadAjax(MultipartFile[] uploadFile){
        //반환할 첨부파일 선언
        List<AttachFileVO> list = new ArrayList<>();

        //담을 폴더생성
        String uploadFolder = getFolder();
        File uploadFolderPath = new File(uploadPath, uploadFolder);
        log.info("uploadFolderPath : " + uploadFolderPath);

        //폴더가 없다면, 생성한다.
        if (uploadFolderPath.exists() == false) {
            uploadFolderPath.mkdirs();
        }

        for (MultipartFile multipartFile : uploadFile) {
            AttachFileVO attachFileVO = new AttachFileVO();

            String uploadFileName = multipartFile.getOriginalFilename();
            //IE 호환조치
            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
            attachFileVO.setFileName(uploadFileName);

            //중복방지
            UUID uuid = UUID.randomUUID();
            uploadFileName = uuid.toString() + "_"  + uploadFileName;

            try{
                File saveFile = new File(uploadFolderPath, uploadFileName);

                attachFileVO.setUuid(uuid.toString());
                attachFileVO.setUploadPath(uploadFolder);

                //이미지파일 썸네일 생성조치
                if (checkImageType(saveFile)) {
                    attachFileVO.setImage(true);
                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolderPath, "s_" + uploadFileName));
                    Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 180, 180);
                    thumbnail.close();
                }

                multipartFile.transferTo(saveFile);//썸네일 오류발생으로 순서는 뒤쪽으로 정의해줘야 함
                list.add(attachFileVO);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("파일 업로드 과정에서 문제가 생겼습니다.");
            } // end try
        } // end for
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * 썸네일 데이터 전송하기
     */
    @GetMapping("/display.do")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(String fileName) {
        File file = new File(uploadPath +"\\"+ fileName);
        log.info("file : " + file);

        ResponseEntity<byte[]> result = null;

        try{
            HttpHeaders headers = new HttpHeaders();

            headers.add("Content-Type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
        } catch (IOException e) {
            log.error("이미지 파일을 가져오는 도중 에러가 발생하였습니다.");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 폴더 생성 메서드(년월일)
     * */
    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = sdf.format(date);
        return str;
    }

    /**
     * 특정한 파일이 이미지 타입인지 검사하는 메서드
     */
    private boolean checkImageType(File file) {
        try {
            String contentType = Files.probeContentType(file.toPath());

            return contentType.startsWith("image");
        } catch(IOException e){
            log.error("이미지 파일 체크 도중 에러 발생");
        }
        return false;
    }
}
