package com.jhs.exam.exam2.container;

import com.jhs.exam.exam2.http.controller.KeywordController;
import com.jhs.exam.exam2.http.controller.UsrArticleController;

import com.jhs.exam.exam2.interceptor.BeforeActionInterceptor;
import com.jhs.exam.exam2.interceptor.NeedLoginInterceptor;
import com.jhs.exam.exam2.interceptor.NeedLogoutInterceptor;
import com.jhs.exam.exam2.repository.ArticleRepository;
import com.jhs.exam.exam2.repository.KeywordRepository;
import com.jhs.exam.exam2.service.ArticleService;
import com.jhs.exam.exam2.service.KeywordService;


public class Container {
	public static BeforeActionInterceptor beforeActionInterceptor;
	public static NeedLoginInterceptor needLoginInterceptor;
	public static NeedLogoutInterceptor needLogoutInterceptor;
	
	public static ArticleRepository articleRepository;
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;

	
	public static KeywordRepository keywordRepository;
	public static KeywordService keyService;
	public static KeywordController keywordController;
	
	public static void init() {
		articleRepository = new ArticleRepository();
	
		
		articleService = new ArticleService();
		
		
		beforeActionInterceptor = new BeforeActionInterceptor();
		needLoginInterceptor = new NeedLoginInterceptor();
		needLogoutInterceptor = new NeedLogoutInterceptor();
		
		usrArticleController = new UsrArticleController();
		
		keywordRepository = new KeywordRepository();
		keyService = new KeywordService();
		keywordController = new KeywordController();
		
	}
}
