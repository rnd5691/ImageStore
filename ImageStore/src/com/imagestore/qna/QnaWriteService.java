package com.imagestore.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;

public class QnaWriteService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		QnaDAO qnaDAO = new QnaDAO();
		String method = request.getMethod();
		if(method.equals("GET"))	{
			request.setAttribute("board", "qna");
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/qna/qnaWrite.jsp");
		}else	{
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setTitle(request.getParameter("title"));
			qnaDTO.setNickname(request.getParameter("nickname"));
			qnaDTO.setContents(request.getParameter("contents"));
			int result = 0;
			
			try {
				result = qnaDAO.insert(qnaDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result>0) {
				actionFoward.setCheck(false);
				actionFoward.setPath("./qnaList.qna");
			}else	{
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/qna/qnaWrite.jsp");
			}
		}
		
		
		return actionFoward;
	}

}
