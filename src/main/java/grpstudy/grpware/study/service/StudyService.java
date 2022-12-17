package grpstudy.grpware.study.service;

import grpstudy.grpware.study.domain.StudyVO;

import java.util.List;

public interface StudyService {
    List<StudyVO> getStudyAll();
    StudyVO getStudy(int bno);
    int setStudy(StudyVO studyVO);
    int updateStudy(StudyVO studyVO);
    int deleteStudy(int bno);
}
