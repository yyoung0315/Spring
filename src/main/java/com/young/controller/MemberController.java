package com.young.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.young.y1.member.MemberServiceImpl;
import com.young.y1.member.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberServiceImpl service;
	
	@RequestMapping("memberform.do")
	String memberform() {
		return "/member/memberform.html";
	}

	@RequestMapping("memberinsert.do")
	String memberinsert(Model model, MemberVO vo) {
		service.memberinsert(vo);
		return "redirect:memberList.do";
	}
	
	@RequestMapping("memberdelete.do")
	String memberdelete(Model model, MemberVO vo) {
		service.memberdelete(vo);
		return "redirect:memberList.do";
	}
	
	@RequestMapping("memberupdate.do")
	String memberupdate(Model model, MemberVO vo) {
		service.memberupdate(vo);
		return "redirect:memberList.do";
	}
	
	
	@RequestMapping("memberList.do")
	String memberList(Model model) {
		model.addAttribute("li", service.memberList(null));
		return "/member/memberList";
	}
	
	@RequestMapping("memberedit.do")
	String memberedit(Model model, MemberVO vo) {
		model.addAttribute("m", service.memberedit(vo));
		return "/member/memberedit";
	}
	
}
