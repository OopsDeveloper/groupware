package grpstudy.grpware.notice.service;

import grpstudy.grpware.notice.domain.NoticeVO;

import java.util.List;

public interface NoticeService {
    List<NoticeVO> getNoticeAll();
    NoticeVO getNotice(int bno);
    int setNotice(NoticeVO noticeVO);
    int updateNotice(NoticeVO noticeVO);
    int deleteNotice(int bno);
}
