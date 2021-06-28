package com.jhs.exam.exam2.service;

import java.util.List;

import com.jhs.exam.exam2.container.Container;
import com.jhs.exam.exam2.dto.Site;
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
	public String getOrigin(String shortCode) {
		return articleRepository.getOrigin(shortCode);
		
	}


	public Site getSite(String originUri) {
		// TODO Auto-generated method stub
		return articleRepository.GetSiteInfo(originUri);
	}


	public List<Site> getSiteList(String tag) {
		// TODO Auto-generated method stub
		return articleRepository.GetSiteList(tag);
	}

}
