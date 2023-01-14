package grpstudy.grpware.refer.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReferVO {

    // 자료실 글 번호
    private int referNo;

    // 자료실 제목
    private String referTitle;

    // 자료실 내용
    private String referContent;

    // 자료실 작성자
    private String referWriter;

    // 자료실 시간
    private String registDt;
    
    // 자료실 파일명
    private String referFname;

    // 실제 업로드할 파일
    private MultipartFile uploadFile;

}
