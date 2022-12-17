package grpstudy.grpware.progress.service;

import grpstudy.grpware.progress.mapper.ProgressMapper;
import grpstudy.grpware.progress.domain.ProgressVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProgressServiceImpl implements ProgressService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProgressMapper progressMapper;

    @Override
    public Map<String, Object> selectProgressRate() throws Exception {

        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            obj.put("status", "SUCCESS");
            obj.put("result_list", progressMapper.selectProgressRate());
        } catch (Exception e) {
            obj.put("status", "ERROR");
            obj.put("statusDescription", "오류 발생");
        }
        return obj;
    }

    @Override
    public List<ProgressVO> selectStudyList() throws Exception {
        return progressMapper.selectStudyList();
    }

    @Override
    public List<HashMap<String, Object>> selectStudyDetailList(HashMap<String, Object> map) {
        return progressMapper.selectStudyDetailList(map);
    }
}
