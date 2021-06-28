package com.jhs.exam.exam2.service;

import com.jhs.exam.exam2.container.Container;
import com.jhs.exam.exam2.repository.ArticleRepository;
import com.jhs.exam.exam2.repository.KeywordRepository;

public class KeywordService {
	private KeywordRepository keywordRepository = Container.keywordRepository;
	public static void insertKeyword(String shortCode, int id, String morph, String pos,String relId) {
		KeywordRepository.insertKeyword(shortCode,id,pos,morph,relId);
		
	}

	
	
}
