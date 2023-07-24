package com.young.y1.psd;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PsdVO {
	private int idx;
	private String title;
	private String img; // 사진 이름 저장, 이름 가져오기 
	private MultipartFile file; //실제 파일 핸들링 
}
