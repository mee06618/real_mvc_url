package com.jhs.exam.exam2.service;

import com.jhs.exam.exam2.container.Container;
import com.jhs.exam.exam2.repository.ArticleRepository;
import com.jhs.exam.exam2.util.SiteTitle;
import com.jhs.exam.exam2.util.random;


public class ArticleService {
	private ArticleRepository articleRepository = Container.articleRepository;

	public int convertSite(String originUri, String shortCode,String text,String blanklessText) {
		
		int row = articleRepository.convertUri(originUri, shortCode, text, blanklessText);

		return row;
	}


	public String getShortCode(String originUri) {
		random ran = new random();
		String shortCode=ran.getRand();
		
		while(articleRepository.constrantCode(shortCode)!=0) {
			shortCode=ran.getRand();
		}
		
		return shortCode;
	}

	public String checkOrigin(String originUri) {
		
		if(articleRepository.CountOriginUri(originUri)==1)
			return articleRepository.GetShort(originUri);
		
		return null;
	}
	public String getText(String originUri) {
		SiteTitle site = new SiteTitle();
				
		return site.getTitle(originUri);
	}

	public String getBlanklessText(String originUri) {
		SiteTitle site = new SiteTitle();
				
		return site.getTitle(originUri).replaceAll(" ","");
	}


}
