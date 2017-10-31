package com.imagestore.qna;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;

public class QnaViewService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		QnaDAO qnaDAO = new QnaDAO();
		
		int qna_seq =0;
		
		try {
			qna_seq = Integer.parseInt(request.getParameter("qna_seq"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		QnaDTO qnaDTO = null;
		
		try {
			qnaDTO = qnaDAO.selectOne(qna_seq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(qnaDTO==null)	{
			try {
				response.sendRedirect("./qnaList.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else	{
			request.setAttribute("login", "admin111");
			request.setAttribute("view", qnaDTO);
			request.setAttribute("board", "qna");
		}
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/qna/qnaView.jsp");
		return actionFoward;
	}

}
