package com.wyreLease.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class PublicController {
	
	@RequestMapping(value="/test")
	public String sayHello(Model model,HttpServletRequest request){
		WebApplicationContext context=RequestContextUtils.getWebApplicationContext(request);
		model.addAttribute("test","helloWorld");
		return "hello";
	}

}
