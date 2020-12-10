package kr.or.iei.model.vo;

public class LgTV implements TV {

	public void powerOn() {
		System.out.println("LgTV ------ 전원ON");
	}
	public void powerOff() {
		System.out.println("LgTV ------ 전원OFF");
	}
	public void volumeUp() {
		System.out.println("LgTV ------ Volume UP");
	}
	public void volumeDown() {
		System.out.println("LgTV ------ Volume DOWN");
	}
}