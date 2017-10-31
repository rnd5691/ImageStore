package com.imagestore.qna;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;
import com.imagestore.util.PageMaker;

public class QnaListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		QnaDAO qnaDAO = new QnaDAO();
		int curPage=1;
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		String kind = request.getParameter("kind");
		if(kind==null)	{
			kind="title";
		}
		String search = request.getParameter("search");
		if(search==null)	{
			search="";
		}
		int totalCount;
		try {
			totalCount = qnaDAO.getTotalCount(kind, search);
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			List<QnaDTO> ar = qnaDAO.selectList(pageMaker.getMakeRow(), kind, search);
			System.out.println(ar.get(0).getQna_seq());
			request.setAttribute("list", ar);
			request.setAttribute("page", pageMaker.getMakePage());
			request.setAttribute("board", "qna");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/qna/qnaList.jsp");
		return actionFoward;
	}

}
