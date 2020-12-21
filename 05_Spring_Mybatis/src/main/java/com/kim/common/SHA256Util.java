package com.kim.common;


import java.security.MessageDigest;

import org.springframework.stereotype.Component;
/* Hash알고리즘(MD-5,SHA-128,SHA-256,SHA-512)
 * 암호화를 지원, 복호화 지원 x=>one way
 * 입력값의 길이와 무관하게 출력 결과의 길이가 고정
 * 입력값이 다르면 출력값은 다름
 * */
//암호화 코드
@Component
public class SHA256Util {
	public String encPw(String memPw) throws Exception{
		//SHA-256 해시알고리즘을 사용하기 위한 객체 생성
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		//입력한 패스워드 값을 바이트 배열로 변경하여 mDigest객체에 대입
		mDigest.update(memPw.getBytes());
		//입력된 byte배열을 16진수로 처리하기 위해 배열로 저장
		byte[] msgStr = mDigest.digest();
		//byte->1byte->8bit->00000000->-128~127->0~255
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<msgStr.length; i++) {
			byte tmpStr = msgStr[i];
			//음수를 양수로 바꾸는 수식처리
			//255는 11111111이므로 & 연산뒤 보수의 값을 256과 더한값 반환
			String tmpTxt = Integer.toString((tmpStr & 0xff)+0x100,16).substring(1);
			sb.append(tmpTxt);
		}
		return sb.toString();
	}
}
