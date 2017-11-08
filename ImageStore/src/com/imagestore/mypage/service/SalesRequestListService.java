package com.imagestore.mypage.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;
import com.imagestore.member.MemberDTO;
import com.imagestore.util.PageMaker;
import com.imagestore.work.WorkDAO;
import com.imagestore.work.WorkDTO;

public class SalesRequestListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ActionFoward actionFoward = new ActionFoward();
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		WorkDAO workDAO = new WorkDAO();
		int curPage = 1;
		try{
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch(Exception e){
		}
		
		int totalCount = 0;
		
		try{
			totalCount = workDAO.getTotalCount();
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			List<WorkDTO> ar = workDAO.selectList(memberDTO.getUser_num(), pageMaker.getMakeRow());
			request.setAttribute("list", ar);
			request.setAttribute("makePage", pageMaker.getMakePage());
		}catch(Exception e){
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/MYPAGE/salesRequestList.jsp");
		
		return actionFoward;
	}

}
