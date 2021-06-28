package com.jhs.exam.exam2.repository;

import java.util.List;

import com.jhs.exam.exam2.dto.Article;
import com.jhs.exam.exam2.dto.Site;
import com.jhs.mysqliutil.MysqlUtil;
import com.jhs.mysqliutil.SecSql;

public class ArticleRepository{
	

	public int convertUri(String originUri, String shortCode,String text,String blanklessText) {
		SecSql sql = new SecSql();
		sql.append("INSERT INTO shortUri");
		sql.append("SET regDate = NOW()");
		sql.append(", updateDate = NOW()");
		sql.append(", memberId= 0");
		sql.append(", originUri = ?", originUri);
		sql.append(", shortCode = ?", shortCode);
		sql.append(", `text` = ?", text);
		sql.append(", `blanklessText` = ?", blanklessText);
		sql.append(", accessCount= 0");
		int id = MysqlUtil.insert(sql);
		
		return id;
	}
	public int constrantCode(String shortCode) {
		SecSql sql = new SecSql();
		sql.append("select count(*) from shortUri");
		sql.append("where shortCode=?",shortCode);

		
		
		return MysqlUtil.selectRowIntValue(sql);
	}

	public String unConvertUri(String shortCode) {
		SecSql sql = new SecSql();
		sql.append("select originUri from shortUri");
		sql.append("where shortCode=?",shortCode);

		
		
		return MysqlUtil.selectRow(sql);
	}

	public int CountOriginUri(String originUri) {
		SecSql sql = new SecSql();
		sql.append("select count(*) from shortUri");
		sql.append("where originUri=?",originUri);

		
		System.out.println(MysqlUtil.selectRowIntValue(sql));
		return MysqlUtil.selectRowIntValue(sql);
	}


	public String GetShort(String originUri) {
		SecSql sql = new SecSql();
		sql.append("select shortCode from shortUri");
		sql.append("where originUri=?",originUri);

		
		
		return MysqlUtil.selectRowStringValue(sql);
	}
			

	public Site GetSiteInfo(String originUri) {
		SecSql sql = new SecSql();
		sql.append("select * from shortUri");
		sql.append("where originUri=?",originUri);

		
		
		return MysqlUtil.selectRow(sql,Site.class);
	}

	public List<Site> GetSiteList(String tag) {
		SecSql sql = new SecSql();
		sql.append("SELECT originUri,`text`,shortCode,");
		sql.append("SUM((CHAR_LENGTH(`blanklessText`)-CHAR_LENGTH(REPLACE(`blanklessText`,?,'')))) as extra__cnt",tag);
		sql.append("FROM shorturi  GROUP BY id" );
		sql.append("HAVING extra__cnt>0 ORDER BY extra__cnt DESC");
	
		
		
		return MysqlUtil.selectRows(sql,Site.class);
	}
	

	public String getOrigin(String ShortCode) {
		SecSql sql = new SecSql();
		sql.append("select originUri from shortUri");
		sql.append("where ShortCode=?",ShortCode);

		
		
		return MysqlUtil.selectRowStringValue(sql);
	}






}
