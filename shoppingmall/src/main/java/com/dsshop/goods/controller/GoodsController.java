package com.dsshop.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@RequestMapping("/insert.do")
	public String insertGoods() {
		System.out.println("insertGoods 호출");
		return "redirect:/";
	}
	@RequestMapping("/select.do")
	public String selectGoods() {
		System.out.println("selectGoods 호출");
		return "redirect:/";
	}
	@RequestMapping("/update.do")
	public String updateGoods() {
		System.out.println("updateGoods 호출");
		return "redirect:/";
	}
}
