package com.young.y1.member;

import java.util.List;

public interface MemberService {
	void memberinsert(MemberVO vo);
	void memberdelete(MemberVO vo);
	void memberupdate(MemberVO vo);
	List<MemberVO> memberList(MemberVO vo);
	MemberVO memberedit(MemberVO vo);
}
