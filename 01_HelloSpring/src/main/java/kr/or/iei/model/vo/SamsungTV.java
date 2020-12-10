package kr.or.iei.model.vo;

public class SamsungTV implements TV {
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
