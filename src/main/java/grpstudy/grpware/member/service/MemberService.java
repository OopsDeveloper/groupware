package grpstudy.grpware.member.service;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.notice.domain.NoticeVO;

import java.util.List;
import java.util.Map;

public interface MemberService {
    MemberVO read(Map<String, Object> params);
    List<MemberVO> getMemberAll();

}