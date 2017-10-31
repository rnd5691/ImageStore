package com.imagestore.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;

public class QnaUpdateService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		QnaDAO qnaDAO = new QnaDAO();
		
		if(method.equals("GET"))	{
			
			
			try {
				int qna_seq = Integer.parseInt(request.getParameter("qna_seq"));
								
				QnaDTO qnaDTO = qnaDAO.selectOne(qna_seq);
				request.setAttribute("view", qnaDTO);
				request.setAttribute("board", "qna");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/qna/qnaUpdate.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else	{
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setQna_seq(Integer.parseInt(request.getParameter("qna_seq")));
			qnaDTO.setTitle(request.getParameter("title"));
			qnaDTO.setContents(request.getParameter("contents"));
			int result = 0;
			
			try {
				result = qnaDAO.update(qnaDTO);
			} catch (Exception e) {
				e.printStackTrace();
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
		}
		
		
		return actionFoward;
	}

}
