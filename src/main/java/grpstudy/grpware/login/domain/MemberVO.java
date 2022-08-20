package grpstudy.grpware.login.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MemberVO {
    private String memberNo;
    private String memberNm;
    private String memberId;
    private String memberPw;
    private Date memberBirth;
    private String memberMail;
    private String memberPhone;
    //private Date registDt;

    private List<AuthVO> authList;
}
