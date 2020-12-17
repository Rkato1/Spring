package com.kim.notice.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kim.notice.model.vo.Notice;
import com.kim.notice.model.vo.NoticeRowMapper;

@Repository
public class NoticeDao {
	@Autowired
	JdbcTemplate jdbc;

	public ArrayList<Notice> selectList(int start, int end) {
		String query = "select * from (select rownum as rnum, n.* from (select * from notice order by 1 desc)n) where rnum between ? and ?";
		Object[] params = {start,end};
		List<Notice> list = jdbc.query(query, params, new NoticeRowMapper());;
		return (ArrayList<Notice>)list;
	}

	public int totalCount() {
		String query = "select count(*) cnt from notice";
		//조회 결과가 1개일때 사용
		int totalCount = jdbc.queryForObject(query, int.class);
		return totalCount;
	}

	public int insertNotice(Notice n) {
		String query = "insert into notice values(notice_seq.nextval,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
		Object[] params = {n.getNoticeTitle(),n.getNoticeWriter(),n.getFilename(),n.getFilepath(),n.getNoticeContent()};
		int result = jdbc.update(query,params);
		return result;
	}

	public Notice selectNotice(int noticeNo) {
		String query = "select * from notice where notice_no=?";
		Object[] params = {noticeNo};
		List<Notice> list = jdbc.query(query, params, new NoticeRowMapper());;
		return list.get(0);
	}
}
