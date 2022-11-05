package grpstudy.grpware.place.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/place")
public class PlaceController {

    @RequestMapping("/place.do")
    public String place(){
        return "place/place";
    }
}
