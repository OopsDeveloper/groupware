package grpstudy.grpware.notice.mapper;

import grpstudy.grpware.notice.domain.NoticeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {
    List<NoticeVO> getNoticeAll();
    NoticeVO getNotice(int bno);
}
