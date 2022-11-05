package grpstudy.grpware.attend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/attend")
public class AttendController {

    @ResponseBody
    @RequestMapping("/attend.do")
    public String attend(String data, HttpServletRequest request) {
        System.out.println("data = " + data);

        return data;
    }
}
