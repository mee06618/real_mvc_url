package com.jhs.exam.exam2.app;

import com.jhs.exam.exam2.container.Container;
import com.jhs.mysqliutil.MysqlUtil;

public class App {
	public static boolean isDevMode() {
		// �씠 遺�遺꾩쓣 false濡� 諛붽씀硫� production 紐⑤뱶 �씠�떎.
		return true;
	}
	
	public static void init() {
		// DB �꽭�똿
		MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "search");
		MysqlUtil.setDevMode(isDevMode());
		
		// 怨듭슜 媛앹껜 �꽭�똿
		Container.init();
	}
}
