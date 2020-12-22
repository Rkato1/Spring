package com.kim.member.model.vo;

import lombok.Data;

@Data
public class DirectMessage {
	int dmNo;
	String dmSender;
	String dmReceiver;
	String message;
	String checkMessage;
	String dmDate;
}
