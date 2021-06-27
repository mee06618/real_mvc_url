package com.jhs.exam.exam2.util;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class SiteTitle {

	public String getTitle(String uri){
		try {
      	HTMLEditorKit htmlKit = new HTMLEditorKit();
        HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
        HTMLEditorKit.Parser parser = new ParserDelegator();
        parser.parse(new InputStreamReader(new URL(uri).openStream()),
                htmlDoc.getReader(0), true);
        
		return htmlDoc.getProperty("title").toString();
		}catch(Exception e){
			
			
			return "";
		}
		
	}

}