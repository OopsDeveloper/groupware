package grpstudy.grpware.review.mapper;

import grpstudy.grpware.review.domain.ReviewVO;

import java.util.List;
import java.util.Map;

public interface ReviewMapper {

    // 기업 후기 메인화면
    public List<ReviewVO> getReviewAll(Map<String, String> map);

    // 기업 후기 상세화면
    public ReviewVO getReviewDetail(String ReviewVO);

    // 기업 후기 등록

    // 기업 후기 수정

    // 기업 후기 삭제
    }
