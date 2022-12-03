package grpstudy.grpware.member.service;

import grpstudy.grpware.auth.domain.MemberVO;
import grpstudy.grpware.notice.domain.NoticeVO;

import java.util.List;
import java.util.Map;

public interface MemberService {
   public MemberVO read(Map<String, Object> params);
   public List<MemberVO> getMemberAll();
   public int deleteMemebr(String id);
   public int updateAuth(String auth, String id);
}