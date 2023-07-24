package com.young.y1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao dao;

	@Override
	public void memberinsert(MemberVO vo) {
		dao.memberinsert(vo);
	}

	@Override
	public void memberdelete(MemberVO vo) {
		dao.memberdelete(vo);	
	}

	@Override
	public void memberupdate(MemberVO vo) {
		dao.memberupdate(vo);
	}

	@Override
	public List<MemberVO> memberList(MemberVO vo) {
		return dao.memberList(vo);
	}

	@Override
	public MemberVO memberedit(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.memberedit(vo);
	}


}
