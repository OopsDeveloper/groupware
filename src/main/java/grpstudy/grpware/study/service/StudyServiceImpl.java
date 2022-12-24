package grpstudy.grpware.study.service;

import grpstudy.grpware.notice.domain.NoticeVO;
import grpstudy.grpware.notice.mapper.NoticeMapper;
import grpstudy.grpware.notice.service.NoticeService;
import grpstudy.grpware.study.domain.StudyVO;
import grpstudy.grpware.study.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    private StudyMapper studyMapper;

    @Override
    public List<StudyVO> getStudyAll() {
        return studyMapper.getStudyAll();
    }

    @Override
    public StudyVO getStudy(int bno) {
        return null;
    }

    @Override
    public int setStudy(StudyVO studyVO) {
        return studyMapper.setStudy(studyVO);
    }

    @Override
    public int updateStudy(StudyVO studyVO) {
        return studyMapper.updateStudy(studyVO);
    }

    @Override
    public int deleteStudy(StudyVO studyVO) {
        return studyMapper.deleteStudy(studyVO);
    }
}
