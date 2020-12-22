package com.kim.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kim.member.model.service.MemberService;
import com.kim.member.model.vo.Member;

@Component
public class ScheduledTest {
	@Autowired
	MemberService service;
	
	/*cron
	 * 초:0~59,*,-,/
	 * 분:0~59,*,-,/
	 * 시간:0~23,*,-,/
	 * 날짜(day of month):1~31,*,-,/,L(해당 월의 마지막 날짜),W(가장 가까운 평일)
	 * 월:1~12,JAN-DEC,*,-,/
	 * 요일:1~7, SUN~SAT,*,-,/,?(해당 항목을 사용하지 않음),#(6#3=>3번째 주 금요일,4#2=>2번째 주 수요일)
	 * [년도]:1970~2099,*,-,/
	 * 
	 * ex : 10 * * * * * => 1분마다 동작(매분 10초마다동작)
	 * 		10-15 * * * * * => 매분 10~15초마다동작
	 * 		00-15 * * * * * => 매분 0초에 시작해서 15초마다동작
	 * 		10 20 * * * * => 매시간 20분 10초마다 동작 -> 1시간에 1번 동작
	 * 		0 0 0 * * * => 매일 자정->하루에 한번	 * 		
	 * */
	
	//자동으로 실행되는 개념이다보니 파라미터를 줄수가 없음(있어도 실행이 안되고 에러발생)
	//그러므로 return타입은 void여야함
	
	//예약작업(Invoke함수와 유사)
//	@Scheduled(fixedDelay = 10000)
//	public void scheduleTest1() {
//		Member m = new Member();
//		m.setMemId("u4");
//		m.setMemPw("1234");
//		Member member = service.selectOneMember(m);		
//		System.out.println(member.getMemName());
//	}
//	
//	@Scheduled(cron = "10 * * * * *")
//	public void scheduleTest2() {
//		System.out.println("매분 10초에 한번씩 실행");
//	}
}
