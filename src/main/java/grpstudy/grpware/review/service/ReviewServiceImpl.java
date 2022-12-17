package grpstudy.grpware.review.service;

import grpstudy.grpware.review.domain.ReviewVO;
import grpstudy.grpware.review.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    // 기업 후기 메인화면
    @Override
    public List<ReviewVO> getReviewAll() {
        return this.reviewMapper.getReviewAll();
    }

    // 기업 후기 상세화면
    @Override
    public ReviewVO getReviewDetail(int revNo) {
        return this.reviewMapper.getReviewDetail(revNo);
    }

    // 기업 후기 등록
    @Override
    public int setReview(ReviewVO reviewVO) {
        return this.reviewMapper.setReview(reviewVO);
    }

    // 기업 후기 수정
    @Override
    public int updateReview(ReviewVO reviewVO) {
        return this.reviewMapper.updateReview(reviewVO);
    }

    // 기업 후기 삭제
    @Override
    public int deleteReveiw(int revNo) {
        return this.reviewMapper.deleteReveiw(revNo);
    }

}

