package grpstudy.grpware.review.controller;

import grpstudy.grpware.review.domain.ReviewVO;
import grpstudy.grpware.review.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String getReviewAll(HttpServletRequest req, Model model,
                               ReviewVO reviewVO){

        HttpSession session = req.getSession();

        model.addAttribute("reviewList", reviewService.getReviewAll());

        return "review/review";
    }

}
