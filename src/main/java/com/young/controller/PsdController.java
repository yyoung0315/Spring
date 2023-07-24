package com.young.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.young.y1.psd.PsdServiceImpl;
import com.young.y1.psd.PsdVO;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletContext;

@Controller
public class PsdController {
	String path = "";

	@Autowired
	private PsdServiceImpl service;

	@Autowired
	private ServletContext servlet;

	@PostConstruct
	public void init() {
		path = servlet.getRealPath("/files/");
		System.out.println("=======>>>>>>   " + path);
	}
	
	@GetMapping("index.do")
	void index() {}
	

	@GetMapping("Psdform.do")
	String Psdform(Model model) {
		model.addAttribute("title", "타임리프 자료실");
		return "/psd/Psdform.html";
	}

	@RequestMapping("insert.do")
	String insert(PsdVO vo) throws IllegalStateException, IOException {

		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
		String formatedNow = now.format(formatter);

		MultipartFile file = vo.getFile();
		String fileName = file.getOriginalFilename();

		File f = new File(path + fileName);
		if (!file.isEmpty()) {
			if (f.exists()) {
				System.out.println("중복파일이 존재합니다. !!!");
				// 파일명 : good.fi.gif
				String onlyFilename = fileName.substring(0, fileName.indexOf("."));
				String onlyExtension = fileName.substring(fileName.indexOf("."), fileName.length());

				fileName = onlyFilename + "_" + formatedNow + onlyExtension;
			}

		} else {
			fileName = "test.png"; // 첨부파일이 없어면 ...
		}

		file.transferTo(new File(path + fileName));
		vo.setImg(fileName);

		service.insert(vo);

		return "redirect:PsdList.do";

	}

	@RequestMapping("PsdList.do")
	String PsdList(Model model) {
		model.addAttribute("li", service.PsdList(null));
		return "/psd/PsdList";
	}

	@RequestMapping("delete.do")
	String delete(PsdVO vo, Model model) throws IllegalStateException, IOException {

		// 삭제할 이미지 읽어오기
		String img = service.selectImg(vo);

		File f = new File(path + img); // 삭제 위해서 f를 만들고
		if (!img.equals("test.png")) {
			f.delete(); // 삭제
		}

		service.delete(vo); // 레코드 삭제

		return "redirect:PsdList.do";

	}

	@RequestMapping("edit.do")
	String edit(Model model, PsdVO vo) {
		model.addAttribute("m", service.edit(vo));
		return "/psd/edit.html";

	}

	@RequestMapping("update.do")
	String update(Model model, PsdVO vo) throws IllegalStateException, IOException {

		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
		String formatedNow = now.format(formatter);

		MultipartFile file = vo.getFile();
		String fileName = file.getOriginalFilename();

		if (fileName.equals("")) {
			service.update1(vo);
			
		} else {
			File f = null;
			String img = service.selectImg(vo);
			 f = new File(path + img); // 삭제 위해서 f를 만들고
			if (!img.equals("test.png")) {
				f.delete(); // 삭제
			}
			//파일 insert
			f = new File(path + fileName);
			if (!file.isEmpty()) {
				if (f.exists()) {
					// 파일명 : good.fi.gif
					String onlyFilename = fileName.substring(0, fileName.indexOf("."));
					String onlyExtension = fileName.substring(fileName.indexOf("."), fileName.length());
					fileName = onlyFilename + "_" + formatedNow + onlyExtension;
				}
			} else {
				fileName = "test.png"; // 첨부파일이 없어면 ...
			}
			file.transferTo(new File(path + fileName));
			vo.setImg(fileName);
			service.update2(vo);
		}
		

		return "redirect:PsdList.do";

	}
}
