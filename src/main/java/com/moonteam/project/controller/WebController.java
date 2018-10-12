package com.moonteam.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moonteam.project.bean.ImUser;
import com.moonteam.project.service.IUserService;

@Controller
public class WebController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("tologin.do")
	public String tologin(){return "login";}
	
	@RequestMapping("Weblogin.do")
	public String login(int username,String password ,HttpServletRequest request,HttpServletResponse response) throws IOException{
		ImUser user = userService.selectById(username);
		if(user!=null&&user.getPassword().equals(password)){
			request.getSession().setAttribute("user", user);
			return "index";
		}
		return "login";
	}
}
