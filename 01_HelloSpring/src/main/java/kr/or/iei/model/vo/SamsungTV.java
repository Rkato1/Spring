package kr.or.iei.model.vo;

import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {
	
	public SamsungTV() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("삼성TV테스트");
	}
	public void powerOn() {
		System.out.println("SamSungTV ------ 전원ON");
	}
	public void powerOff() {
		System.out.println("SamSungTV ------ 전원OFF");
	}
	public void volumeUp() {
		System.out.println("SamSungTV ------ Volume UP");
	}
	public void volumeDown() {
		System.out.println("SamSungTV ------ Volume DOWN");
	}
}
