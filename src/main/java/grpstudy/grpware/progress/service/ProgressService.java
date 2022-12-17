package grpstudy.grpware.progress.service;

import grpstudy.grpware.progress.domain.ProgressVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProgressService {
    public Map<String, Object> selectProgressRate() throws Exception;

    public List<ProgressVO> selectStudyList() throws Exception;

    List<HashMap<String, Object>> selectStudyDetailList(HashMap<String, Object> map);
}
