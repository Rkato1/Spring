package kr.or.test.ano;

import org.springframework.stereotype.Component;

//xml에서 bean만든것과 같음
@Component
public class Computer {

	public Computer() {
		super();
		System.out.println("컴퓨터 객체 생성 완료!!");
		// TODO Auto-generated constructor stub
	}
	public void testMsg() {
		System.out.println("테스트메시지");
	}
	
}
