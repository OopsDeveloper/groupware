package grpstudy.grpware.progress.domain;

import lombok.Data;

@Data
public class ProgressVO {
    private int seq;
    private String title;
    private String content;
    private String nm;
    private String checkYn;
}
