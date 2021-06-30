package com.jhs.exam.exam2.container;

import com.jhs.exam.exam2.http.controller.KeywordController;
import com.jhs.exam.exam2.http.controller.UsrArticleController;
import com.jhs.exam.exam2.http.controller.UsrMemberController;
import com.jhs.exam.exam2.interceptor.BeforeActionInterceptor;
import com.jhs.exam.exam2.interceptor.NeedLoginInterceptor;
import com.jhs.exam.exam2.interceptor.NeedLogoutInterceptor;
import com.jhs.exam.exam2.repository.ArticleRepository;
import com.jhs.exam.exam2.repository.KeywordRepository;
import com.jhs.exam.exam2.repository.MemberRepository;
import com.jhs.exam.exam2.service.ArticleService;
import com.jhs.exam.exam2.service.KeywordService;
import com.jhs.exam.exam2.service.MemberService;


public class Container {
	public static BeforeActionInterceptor beforeActionInterceptor;
	public static NeedLoginInterceptor needLoginInterceptor;
	public static NeedLogoutInterceptor needLogoutInterceptor;
	
	public static ArticleRepository articleRepository;
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;

	
	public static KeywordRepository keywordRepository;
	public static KeywordService keywordService;
	public static KeywordController keywordController;
	
	public static MemberRepository memberRepository;
	public static MemberService memberService;
	public static UsrMemberController usrMemberController;
	public static void init() {
		articleRepository = new ArticleRepository();
	
		
		articleService = new ArticleService();
		
		
		beforeActionInterceptor = new BeforeActionInterceptor();
		needLoginInterceptor = new NeedLoginInterceptor();
		needLogoutInterceptor = new NeedLogoutInterceptor();
		
		usrArticleController = new UsrArticleController();
		
		keywordRepository = new KeywordRepository();
		keywordService = new KeywordService();
		keywordController = new KeywordController();
		
		usrMemberController = new UsrMemberController();
		memberRepository = new MemberRepository();
		memberService = new MemberService();
		
	}
}
