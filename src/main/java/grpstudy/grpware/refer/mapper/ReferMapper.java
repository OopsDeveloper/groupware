package grpstudy.grpware.refer.mapper;

import grpstudy.grpware.refer.domain.ReferVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferMapper {

    // 자료실 메인 화면
    public List<ReferVO> getReferAll();

    // 자료실 상세 화면
    public ReferVO getReferDetail(int referNo);

    // 자료실 글 등록
    public int setRefer(ReferVO referVO);

    // 자료실 글 수정
    public int updateRefer(ReferVO referVO);

    // 자료실 글 삭제
    public int deleteRefer(int referNO);
}
