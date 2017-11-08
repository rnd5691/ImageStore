package com.imagestore.qna.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;
import com.imagestore.qna.QnaDAO;
import com.imagestore.qna.QnaDTO;
import com.imagestore.util.PageMaker;

public class QnaListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ActionFoward actionFoward = new ActionFoward();
		
		QnaDAO qnaDAO = new QnaDAO();
		int curPage = 1;
		try{
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch(Exception e){
		}
		
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		
		if(kind==null){
			kind="title";
		}
		if(search==null){
			search="";
		}
		
		int totalCount = 0;
		
		try{
			totalCount = qnaDAO.getTotalCount(kind, search);
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			List<QnaDTO> ar = qnaDAO.selectList(pageMaker.getMakeRow(), kind, search);
			request.setAttribute("list", ar);
			request.setAttribute("makePage", pageMaker.getMakePage());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/qna/qnaList.jsp");
		
		return actionFoward;
	}

}
