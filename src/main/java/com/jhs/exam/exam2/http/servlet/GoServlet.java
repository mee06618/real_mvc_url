package com.jhs.exam.exam2.http.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jhs.exam.exam2.container.Container;
import com.jhs.exam.exam2.dto.Site;
import com.jhs.exam.exam2.http.Rq;
import com.jhs.exam.exam2.http.controller.Controller;
import com.jhs.exam.exam2.service.ArticleService;
import com.jhs.exam.exam2.service.KeywordService;
import com.jhs.exam.exam2.util.Ut;
import com.jhs.mysqliutil.MysqlUtil;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;


@WebServlet("/go/*")
public class GoServlet extends DispatcherServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Rq rq = new Rq(req, resp);
		  req.setCharacterEncoding("UTF-8");
	        resp.setContentType("text/html; charset=UTF-8");



		rq.replace(rq.getRequestUri(), rq.getRequestUri());

		
		if(rq.getActionMethodName()=="doAdd") {
			String originUri = req.getParameter("originUri");
			

		String shortCode="";
		if(originUri==null)
			originUri=rq.getParam();
		ArticleService service = new ArticleService();
		if(service.getText(originUri)=="") {
			
			resp.sendRedirect("/search");
		}
		else {
		String text=service.getText(originUri);
		
		if(service.checkOrigin(originUri)==null) {
		
		shortCode=service.getShortCode(originUri);
		rq.setParam1(shortCode);
		service.convertSite(originUri, shortCode, text, service.getBlanklessText(originUri));
		Site temp = service.getSite(originUri);
		
		
		 Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		    String strToAnalyze = temp.getText();

		    KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);


		    List<Token> tokenList = analyzeResultList.getTokenList();
		    for (Token token : tokenList) {
		    	if(token.getPos()!="SS" && token.getPos()!="XP"&& token.getPos()!="XSN")
		        KeywordService.insertKeyword(shortCode, temp.getMemberId(),shortCode,  token.getMorph(),  token.getPos());
		    }
		
		}else {
			shortCode=service.checkOrigin(originUri);
		}
		
		resp.sendRedirect("/search?shortCode="+shortCode);
		}
		}	
		else if(rq.getActionMethodName()=="goByText") {
			String tag = req.getParameter("tag");
		
			ArticleService service = new ArticleService();
			if(service.getSiteList(tag)!=null) {
			List<Site> list = service.getSiteList(tag);
			for(Site temp : list) {
				System.out.println(temp.getText());
			}
			HttpSession session = req.getSession();
			session.setAttribute("list",list);
			}
		
			resp.sendRedirect("/search/searchKeyword.jsp?tag="+tag);
		}
		else if(rq.getActionMethodName()=="goByShortCode"){
			ArticleService service = new ArticleService();
			String shortCode = rq.getParam1();
			if(service.getOrigin(shortCode)!="")
				
			resp.sendRedirect(service.getOrigin(shortCode));
			else {
				resp.sendRedirect("/search");
			}
		}
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Rq rq = new Rq(req, resp);
		if(rq.getActionMethodName()=="goByText") {
		
			resp.sendRedirect("/search/searchKeyword.jsp");
		}
	}
}
