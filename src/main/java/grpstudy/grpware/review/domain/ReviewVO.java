package grpstudy.grpware.review.domain;

import lombok.Data;

@Data
public class ReviewVO {

   // 기업 후기 글 번호
   private int revNo;

   // 기업 후기 제목
   private String revTitle;

   // 기업 후기 내용
   private String revContent;

   // 기업 후기 작성자
   private String revWriter;

   // 기업 후기 작성 시간
   private String registDt;



}
