package com.jhs.exam.exam2.http.controller;

import com.jhs.exam.exam2.dto.ResultData;
import com.jhs.exam.exam2.http.Rq;
import com.jhs.exam.exam2.http.service.ArticleService;

public class UsrArticleController extends Controller {
	private ArticleService articleService;

	public UsrArticleController() {
		articleService = new ArticleService();
	}

	@Override
	public void performAction(Rq rq) {
		switch (rq.getActionMethodName()) {
		case "write":
			actionShowWrite(rq);
			break;
		case "doWrite":
			actionDoWrite(rq);
			break;
		}
	}

	private void actionDoWrite(Rq rq) {
		String title = rq.getParam("title", "");
		String body = rq.getParam("body", "");

		if (title.length() == 0) {
			rq.historyBack("title을 입력해주세요.");
			return;
		}

		if (body.length() == 0) {
			rq.historyBack("body를 입력해주세요.");
			return;
		}

		ResultData writeRd = articleService.write(title, body);

		rq.printf(writeRd.getMsg());
	}

	private void actionShowWrite(Rq rq) {
		rq.jsp("usr/article/write");
	}
}