package com.jhs.exam.exam2.http.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhs.exam.exam2.container.Container;
import com.jhs.exam.exam2.http.Rq;
import com.jhs.exam.exam2.http.controller.Controller;
import com.jhs.exam.exam2.service.ArticleService;
import com.jhs.exam.exam2.util.Ut;
import com.jhs.mysqliutil.MysqlUtil;

@WebServlet("/go/*")
public class GoServlet extends DispatcherServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Rq rq = new Rq(req, resp);
		String originUri = req.getParameter("originUri");
		rq.setParam1(originUri);
		rq.replace(rq.getRequestUri(), rq.getRequestUri());
		
		String shortCode="";
		ArticleService service = new ArticleService();
		//if(service.getText(originUri)=="") {
		//	resp.sendRedirect("project");
		//}
		
		String text=service.getText(originUri);
		System.out.println("aa : "+text);
		
		
		if(service.checkOrigin(originUri)==null) {
		
		shortCode=service.getShortCode(originUri);
		
		}else {
			shortCode=service.checkOrigin(originUri);
		}
		System.out.println("short : "+shortCode);
		resp.sendRedirect("/project?shortCode="+shortCode);
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
