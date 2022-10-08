package grpstudy.grpware.notice.service;

import grpstudy.grpware.notice.domain.NoticeVO;
import grpstudy.grpware.notice.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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

    @Override
    public int setNotice(NoticeVO noticeVO) {
        //등록일 저장
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        noticeVO.setRegistDt(formatter.format(now));

        System.out.println("noticeVO = " + noticeVO);

        int cnt = noticeMapper.setNotice(noticeVO);

        System.out.println("cnt = " + cnt);
        return cnt;
    }

    @Override
    public int updateNotice(NoticeVO noticeVO) {
        System.out.println("noticeVO = " + noticeVO);
        int cnt = noticeMapper.updateNotice(noticeVO);
        return cnt;
    }

    @Override
    public int deleteNotice(int bno) {
        System.out.println("bno = " + bno);
        int cnt = noticeMapper.deleteNotice(bno);
        return cnt;
    }
}
