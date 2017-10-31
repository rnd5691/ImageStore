package com.imagestore.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;

public class MemberInfoService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		if(method.equals("GET")){
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/join/joinForm_info.jsp");
		}
		return actionFoward;
	}

}
