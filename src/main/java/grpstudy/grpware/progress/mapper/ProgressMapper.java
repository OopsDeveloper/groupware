package grpstudy.grpware.progress.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProgressMapper {
    List<Map<String,Object>> selectProgressRate() throws Exception;
}
