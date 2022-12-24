package grpstudy.grpware.study.mapper;

import grpstudy.grpware.notice.domain.NoticeVO;
import grpstudy.grpware.study.domain.StudyVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyMapper {
    List<StudyVO> getStudyAll();
    StudyVO getStudy(int bno);
    int setStudy(StudyVO studyVO);
    int updateStudy(StudyVO studyVO);
    int deleteStudy(StudyVO studyVO);
}
