package grpstudy.grpware.member.service;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.notice.domain.NoticeVO;

import java.util.List;

public interface MemberService {
    List<MemberVO> getMemberAll();

}