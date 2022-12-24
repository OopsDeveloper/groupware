package grpstudy.grpware.study.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import grpstudy.grpware.study.domain.StudyVO;
import grpstudy.grpware.study.service.StudyService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/study")
public class StudyController {

    @Autowired
    private StudyService studyService;

    @RequestMapping("/study.do")
    public String study() {
        return "study/study";
    }

    @RequestMapping("/getStudy.do")
    @ResponseBody
    public List<Map<String,Object>> getStudy(){
        List<StudyVO> listAll= studyService.getStudyAll();

        JSONObject jsonObj = new JSONObject();
        JSONArray jsonArr = new JSONArray();

        HashMap<String, Object> hash = new HashMap<>();

        for (int i = 0; i < listAll.size(); i++) {
            hash.put("title", listAll.get(i).getTitle());
            hash.put("start", listAll.get(i).getStart());
            hash.put("end", listAll.get(i).getEnd());
            hash.put("no", listAll.get(i).getNo());

            jsonObj = new JSONObject(hash);
            jsonArr.add(jsonObj);
        }
        return jsonArr;
    }

    @RequestMapping("/regist.do")
    @ResponseBody
    public String regist(StudyVO vo){
        int cnt = studyService.setStudy(vo);

        if(cnt <= 0){
            return "NOK";
        } else{
            return "OK";
        }
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(StudyVO vo){
        int cnt = studyService.deleteStudy(vo);

        if(cnt <= 0){
            return "NOK";
        } else{
            return "OK";
        }
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public String update(StudyVO vo){
        int cnt = studyService.updateStudy(vo);

        if(cnt <= 0){
            return "NOK";
        } else{
            return "OK";
        }
    }
}

