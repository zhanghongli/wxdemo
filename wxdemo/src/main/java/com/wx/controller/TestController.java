package com.wx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping(value="test.do")
	public String test(HttpServletRequest request, HttpServletResponse response){
		
		String name = request.getParameter("name");
		String author = request.getParameter("author");
				
		System.out.println("----------->测试请求");
		System.out.println(name + ", " + author);
		
		return "success";
	}
	
	
}
