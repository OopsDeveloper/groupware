package grpstudy.grpware.refer.controller;

import grpstudy.grpware.common.utils.CommonUtils;
import grpstudy.grpware.refer.domain.ReferVO;
import grpstudy.grpware.refer.service.ReferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/refer")
public class ReferController {

    @Autowired
     private ReferService referService;

    // 자료실 글 목록
    @RequestMapping("/refer.do")
    public String getReferAll(Model model){

        model.addAttribute("referList", referService.getReferAll());

        return "refer/refer";
    }

    // 자료실 글 상세
    @GetMapping("/referView.do")
    public String getReferDetail(Model model, int referNo){
        model.addAttribute("refer", referService.getReferDetail(referNo));

        return "refer/referView";
    }

    // 자료실 글 등록 get
    @GetMapping("/referRegist.do")
    public String getReferRegist(Model model){
        model.addAttribute("loginId", CommonUtils.getLoginId());

        return "refer/referRegist";
    }

    // 자료실 글 등록 post
    @PostMapping("/referRegist.do")
    public String postReferRegist(ReferVO referVO, HttpServletRequest request){

        // 파일이 업로드될 실제 폴더의 경로 지정(/webapp/psd)
        String Realpath = request.getSession().getServletContext().getRealPath("/file/");

        System.out.println("Realpath : " + Realpath);

        // form.jsp에서 받아와서 Set한 VO uploadFile 값을 get해서 uploadFile 변수에 저장
        MultipartFile uploadFile = referVO.getUploadFile();


        if(!uploadFile.isEmpty()){
            // 업로드한 파일이 비어 있지 않다면.
            try {
                String genId = UUID.randomUUID().toString();
                String originalFileName = uploadFile.getOriginalFilename();
                String onlyFile = originalFileName.substring(0, originalFileName.lastIndexOf("."));
                String extention = FilenameUtils.getExtension(originalFileName);
                String saveFilename = onlyFile + genId.substring(0,3) + "." + extention;
                referVO.setReferFname(saveFilename);

                uploadFile.transferTo(new File(Realpath+saveFilename));

            }catch (IllegalStateException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            referVO.setReferFname("emtpy.jpg");
        }
        referService.setRefer(referVO);

        System.out.println("referVO : " + referVO);

        //int cnt = referService.setRefer(referVO);

        return "redirect:/refer/refer.do";
    }

    // 자료실 수정 화면
    @GetMapping("/referModify.do")
    public String getReferModify(int referNo, Model model){
        model.addAttribute("refer", referService.getReferDetail(referNo));

        return "refer/referModify";
    }
    // 자료실 수정 내용
    @PostMapping("/referUpdate.do")
    public String postReferUpdate(ReferVO referVO, Model model){
        int cnt = referService.updateRefer(referVO);

        model.addAttribute("refer", referService.getReferDetail(referVO.getReferNo()));

        return "refer/referView";
    }

    // 자료실 글 삭제
    @RequestMapping("/referDelete.do")
    public String referDelete(int referNo, Model model){
        referService.deleteRefer(referNo);

        return "redirect:/refer/refer.do";
    }
}
