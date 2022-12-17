package grpstudy.grpware.refer.service;

import grpstudy.grpware.refer.domain.ReferVO;
import grpstudy.grpware.refer.mapper.ReferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferServiceImpl {

    @Autowired
    private ReferMapper referMapper;

    // 자료실 메인 화면
    public List<ReferVO> getReferAll(){
        return this.referMapper.getReferAll();
    };

    // 자료실 상세 화면
    public ReferVO getReferDetail(int referNo){
        return this.referMapper.getReferDetail(referNo);
    };

    // 자료실 글 등록
    public int setRefer(ReferVO referVO){
        return this.referMapper.setRefer(referVO);
    };

    // 자료실 글 수정
    public int updateRefer(ReferVO referVO){
        return this.referMapper.updateRefer(referVO);
    };

    // 자료실 글 삭제
    public int deleteRefer(int referNO){
        return this.referMapper.deleteRefer(referNO);
    };
}
