package com.jhs.exam.exam2.http.controller;

import java.util.List;

import com.jhs.exam.exam2.container.Container;
import com.jhs.exam.exam2.dto.Article;
import com.jhs.exam.exam2.dto.ResultData;
import com.jhs.exam.exam2.http.Rq;
import com.jhs.exam.exam2.service.ArticleService;
import com.jhs.exam.exam2.util.SiteTitle;
import com.jhs.exam.exam2.util.Ut;

public class KeywordController extends Controller {
	private ArticleService aritcleService = Container.articleService;

	@Override
	public void performAction(Rq rq) {
		switch (rq.getActionMethodName()) {
		case "convert":
			//actionConvertSite(rq);
			break;

		default:
			rq.println("존재하지 않는 페이지 입니다.");
			break;
		}
	}

	
	
	private void actionKeyword(Rq rq) {
		String originUri = rq.getParam("originUri", "");
		
		String shortCode= aritcleService.getShortCode(originUri);
		String text = aritcleService.getText(originUri);
		String blankText = aritcleService.getBlanklessText(originUri);
		aritcleService.convertSite(originUri,shortCode,text,blankText);
		rq.setAttr("shortCode", shortCode);
		rq.jsp("index");
	}
}
