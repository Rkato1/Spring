package com.kim.notice.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kim.notice.model.service.NoticeService;
import com.kim.notice.model.vo.Notice;
import com.kim.notice.model.vo.NoticePageData;

import common.FileNameOverlap;

@Controller
public class NoticeController {
	@Autowired
	NoticeService service;
	
	@RequestMapping("/noticeList.do")
	public String noticeList(int reqPage, Model model) {
		NoticePageData npd = service.noticeList(reqPage);
		model.addAttribute("list",npd.getList());
		model.addAttribute("pageNavi",npd.getPageNavi());
		return "notice/noticeList";		
	}
	
	@RequestMapping("/noticeForm.do")
	public String noticeForm() {
		return "notice/noticeForm";
	}
	
	@RequestMapping("/insertNotice.do")
	public String insertNotice(Notice n, MultipartFile file, HttpServletRequest request, Model model) {
		/*매개변수 설명
		 * Notice->제목 작성자 본문내용 가져오는 변수
		 * MultipartFile->업로드하는 파일을 가져오는 변수
		 * HttpServletRequest->업로드 경로를 가져오는 변수
		 * Model->결과처리를 위한 변수
		 * */
		//1.업로드 경로지정(이 경우는 루트 디렉토리의 경로)
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"resources/upload/notice/";
		//2.파일처리		
		if(!file.isEmpty()) {
			//실제 파일의 이름
			String filename = file.getOriginalFilename();
			//파일이 저장될 경로(중복체크로직 거친후)
			String filepath = new FileNameOverlap().rename(path, filename);
			//파일 업로드 시작
			try {
				//업로드 할 파일을 byte[]형태로 변환
				byte[] bytes = file.getBytes();
				//업로드할 파일객체 생성
				File upFile = new File(path+filepath);
				//파일 내보내기 위한 메인,보조스트림 생성
				FileOutputStream fos = new FileOutputStream(upFile);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				//파일저장
				bos.write(bytes);
				bos.close();
				//insert할 notice객체에 각각 값 대입
				n.setFilename(filename);
				n.setFilepath(filepath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int result = service.insertNotice(n);
		if(result>0) {
			model.addAttribute("msg","공지사항 작성 완료");
		}else {
			model.addAttribute("msg","공지사항 작성 실패");
		}
		model.addAttribute("loc","/noticeList.do?reqPage=1");
		return "common/msg";
	}
	
	@RequestMapping("/noticeView.do")
	public String noticeView(int noticeNo, Model model) {
		Notice n = service.selectNotice(noticeNo);
		System.out.println("NUM = "+n.getNoticeNo());
		model.addAttribute("n",n);
		return "notice/noticeView";
	}
}
