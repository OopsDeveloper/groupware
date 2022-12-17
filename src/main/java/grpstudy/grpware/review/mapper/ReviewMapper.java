package grpstudy.grpware.review.mapper;

import grpstudy.grpware.review.domain.ReviewVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReviewMapper {

    // 기업 후기 메인화면
    public List<ReviewVO> getReviewAll();

    // 기업 후기 상세화면
    public ReviewVO getReviewDetail(int revNo);

    // 기업 후기 등록
    public int setReview(ReviewVO reviewVO);

    // 기업 후기 수정
    public int updateReview(ReviewVO reviewVO);

    // 기업 후기 삭제
    public int deleteReview(int reviewVO);
    }
