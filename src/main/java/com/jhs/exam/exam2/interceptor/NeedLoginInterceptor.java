package com.jhs.exam.exam2.interceptor;

import com.jhs.exam.exam2.http.Rq;

public class NeedLoginInterceptor extends Interceptor {

	@Override
	public boolean runBeforeAction(Rq rq) {
		switch (rq.getActionPath()) {
		case "/shortUri/doAdd":
		case"/usr/doLogout":
		case "/usr/doLogin":
		case "/usr/doJoin":
		case "/usr/findLoginId":
		case "/usr/doFindLoginId":
		case "/usr/findLoginPw":
		case "/usr/doFindLoginPw":
			return true;

		}
		
		if ( !rq.isNotLogined() ) {
			rq.historyBack("로그인 후 이용해주세요.");
			
			return false;
		}

		return true;
	}

}
