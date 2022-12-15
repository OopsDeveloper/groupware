package grpstudy.grpware.review.controller;

import grpstudy.grpware.common.utils.CommonUtils;
import grpstudy.grpware.review.domain.ReviewVO;
import grpstudy.grpware.review.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    // 게시판 글 목록
    @GetMapping("/review.do")
    public String getReviewAll(Model model){

        model.addAttribute("reviewList", reviewService.getReviewAll());

        return "review/review";
    }

    // 게시판 글 상세
    @GetMapping("/reviewView.do")
    public String getReviewDetail(Model model, int revNo){
        model.addAttribute("review", reviewService.getReviewDetail(revNo));

                return "review/reviewView";
    }

    // 게시판 등록 get
    @GetMapping("/reviewRegist.do")
    public String getReviewRegist(Model model){
        model.addAttribute("loginId", CommonUtils.getLoginId());

        return "review/reviewRegist";
    }

    // 게시판 등록 post
    @PostMapping("/reviewRegist.do")
    public String postReviewRegist(ReviewVO reviewVO){
        System.out.println("reviewVO = " + reviewVO);
        int cnt = reviewService.setReview(reviewVO);

        return "redirect:/review/review.do";
    }

    // 게시판 수정 화면
    @GetMapping("/reviewModify.do")
    public String getReviewModify(int revNo, Model model){
        model.addAttribute("review", reviewService.getReviewDetail(revNo));

        return "review/reviewModify";
    }

    // 게시판 수정 내용
    @PostMapping("/reviewUpdate.do")
    public String postReviewUpdate(ReviewVO reviewVO, Model model){
        int cnt = reviewService.updateReview(reviewVO);

        model.addAttribute("review", reviewService.getReviewDetail(reviewVO.getRevNo()));

        return "review/reviewView";
    }

    // 게시글 삭제
    @RequestMapping("/reviewDelete.do")
    public String reviewDelete(int revNo, Model model){
        reviewService.deleteReveiw(revNo);

        return "redirect:/review/review.do";
    }



}
