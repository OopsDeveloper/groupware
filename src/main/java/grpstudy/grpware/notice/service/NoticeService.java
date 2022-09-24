package grpstudy.grpware.notice.service;

import grpstudy.grpware.notice.domain.NoticeVO;

import java.util.List;

public interface NoticeService {
    List<NoticeVO> getNoticeAll();
    NoticeVO getNotice(int bno);
}
