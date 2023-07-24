package com.young.y1.member;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String name;
	private String password; // 사진 이름 저장, 이름 가져오기 
	private String role; //실제 파일 핸들링 
}
