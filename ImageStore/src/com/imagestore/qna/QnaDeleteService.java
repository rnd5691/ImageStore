package com.imagestore.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;

public class QnaDeleteService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		QnaDAO qnaDAO = new QnaDAO();
		int num = 0;
		int result = 0;	
		try {
			num = Integer.parseInt(request.getParameter("num"));
			
			
			result = qnaDAO.delete(num);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(result>0)	{
			request.setAttribute("message", "OK");
			request.setAttribute("path", "./qnaList.qna");
		}else	{
			request.setAttribute("message", "FAIL");
			request.setAttribute("path", "./qnaList.qna");
		}
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/common/result.jsp");
		
		return actionFoward;
	}

}
