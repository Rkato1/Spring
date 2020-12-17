package com.kim.notice.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.notice.model.dao.NoticeDao;
import com.kim.notice.model.vo.Notice;
import com.kim.notice.model.vo.NoticePageData;

@Service
public class NoticeService {
	@Autowired
	NoticeDao dao;

	public NoticePageData noticeList(int reqPage) {
		//게시물 구해오기
		//한 페이지당 게시물 수
		int numPerPage = 10;
		//게시물 10개 가져오기(start,end값 계산)		
		int end = reqPage*numPerPage;
		//int start = (reqPage-1)*numPerPage+1;
		int start = end-numPerPage+1;
		ArrayList<Notice> list = dao.selectList(start,end);
		//pageNavi제작
		//총 게시물의 개수
		int totalCount = dao.totalCount();
		//총 페이지 수
		int totalPage=0;
		if(totalCount%numPerPage==0) {
			totalPage=totalCount/numPerPage;
		}else {
			totalPage=totalCount/numPerPage+1;
		}
		//페이지네비의 길이
		int pageNaviSize=5;
		//페이지 네비 시작 번호
		int pageNo=((reqPage-1)/pageNaviSize)*pageNaviSize +1;
		//페이지 네비 작성
		String pageNavi = "";
		//이전 버튼 생성
		if(pageNo!=1) {
			pageNavi += "<a href='/noticeList.do?reqPage="+(pageNo-1)+"'>[이전]</a>";
		}
		for(int i=0; i<pageNaviSize; i++) {
			if(pageNo != reqPage) {
				pageNavi += "<a href='/noticeList.do?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}else {
				pageNavi += "<span class='selectedPage'>"+pageNo+"</span>";
			}
			pageNo++;
			//끝 페이지라면
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음 버튼 생성
		if(pageNo <= totalPage) {
			pageNavi += "<a href='/noticeList.do?reqPage="+pageNo+"'>[다음]</a>";;
		}
		System.out.println(pageNavi);
		NoticePageData npd = new NoticePageData(list,pageNavi);
		return npd;
	}

	public int insertNotice(Notice n) {
		int result = dao.insertNotice(n);
		return result;
	}

	public Notice selectNotice(int noticeNo) {
		Notice n = dao.selectNotice(noticeNo);
		return n;
	}
}
