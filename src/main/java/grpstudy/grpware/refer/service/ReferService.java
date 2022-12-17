package grpstudy.grpware.refer.service;

import grpstudy.grpware.refer.domain.ReferVO;

import java.util.List;

public interface ReferService {
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
