package com.jhs.exam.exam2.repository;

import java.util.List;

import com.jhs.exam.exam2.dto.Article;
import com.jhs.exam.exam2.dto.Site;
import com.jhs.mysqliutil.MysqlUtil;
import com.jhs.mysqliutil.SecSql;

public class KeywordRepository{
	

	public static void insertKeyword(String shortCode, int id, String pos, String morph,String relId) {
		SecSql sql = new SecSql();
		// TODO Auto-generated method stub
		sql.append("INSERT IGNORE INTO keyword");
		sql.append("SET regDate = NOW()");
		sql.append(", updateDate = NOW()");
		sql.append(", memberId= ?",id);
		sql.append(", keyStr = ?", pos);
		sql.append(", relTypeCode = ?", shortCode);
		sql.append(", relId = ?", relId);
		MysqlUtil.insert(sql);
	}
	


}
