package grpstudy.grpware.notice.service;

import grpstudy.grpware.notice.domain.NoticeVO;
import grpstudy.grpware.notice.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<NoticeVO> getNoticeAll() {
        return noticeMapper.getNoticeAll();
    }

    @Override
    public NoticeVO getNotice(int bno) {
        return noticeMapper.getNotice(bno);
    }
}
