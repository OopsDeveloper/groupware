package grpstudy.grpware.place.controller;

import grpstudy.grpware.place.domain.PlaceVO;
import grpstudy.grpware.place.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping("/place.do")
    public String place(){
        return "place/place";
    }

    @ResponseBody
    @RequestMapping("/setPlace.do")
    public String setPlace(PlaceVO vo){
        int chk = placeService.setPlace(vo);
        if(chk > 0 ){
            return "OK";
        } else {
            return "NOK";
        }
    }
}
