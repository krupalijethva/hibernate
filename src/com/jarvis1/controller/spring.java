package com.jarvis1.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jarvis1.dao.insertDao;
import com.jarvis1.vo.loginVo;
import com.jarvis1.vo.regVo;


@Controller
public class spring {
	
	@Autowired
	insertDao rd;
	@RequestMapping(value="/hello.do",method=RequestMethod.GET)
	public ModelAndView hello()
	{
		String msg="hey, my first spring helloword...";
		return new ModelAndView("hello","hi",msg);
	}
	public ModelAndView login()
	{
		return new ModelAndView("login","reg",new regVo());
	}
	
	@RequestMapping(value="/reg.do",method=RequestMethod.GET)
	public ModelAndView reg()
	{
		return new ModelAndView("reg","reg",new regVo());
	}
	
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute regVo obj,HttpSession ss,HttpServletRequest req)
	{
		String fn=req.getParameter("fname");
		String ln=req.getParameter("lname");
		String un=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		ss.setAttribute("fname", fn);
		ss.setAttribute("lname", ln);
		ss.setAttribute("uname", un);
		ss.setAttribute("pwd", pwd);	
		rd.insertDa(obj);
		return new ModelAndView("login","reg",obj);
	}
	@RequestMapping(value="/login1.do",method=RequestMethod.GET)
	public ModelAndView login(@ModelAttribute loginVo obj,HttpSession ss,HttpServletRequest req)
	{
		List ls=new ArrayList();
		String un=req.getParameter("uname1");
		String pwd=req.getParameter("pwd1");
		obj.setUname1(un);
		obj.setPwd1(pwd);
		ls=rd.login(obj);
		HttpSession session = req.getSession();
		session.setAttribute("ls", ls);
		if(ls.isEmpty())
		{	
			return new ModelAndView("welcome","wc",obj);
			
		}
		else
		{
			return new ModelAndView("login","reg",obj);
		}
		
	}
	@RequestMapping(value="/flag.do",method=RequestMethod.GET)
	public ModelAndView flag()
	{
		return new ModelAndView("detailspass","reg",new regVo());
	}
	@RequestMapping(value="/detailspas.do",method=RequestMethod.POST)
	public ModelAndView detailspass(@ModelAttribute regVo regvo)
	{
		List ls=new ArrayList();
		ls=rd.search(regvo);
		return new ModelAndView("show").addObject("list",ls);
	}

}