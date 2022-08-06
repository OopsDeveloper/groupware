package grpstudy.grpware.common.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SampleVO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updateDate;

    private int replyCnt;
}
