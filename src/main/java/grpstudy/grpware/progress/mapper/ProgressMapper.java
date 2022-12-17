package grpstudy.grpware.progress.mapper;

import grpstudy.grpware.progress.domain.ProgressVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ProgressMapper {
    List<Map<String,Object>> selectProgressRate() throws Exception;

    List<ProgressVO> selectStudyList() throws Exception;

    List<HashMap<String, Object>> selectStudyDetailList(HashMap<String, Object> map);
}
