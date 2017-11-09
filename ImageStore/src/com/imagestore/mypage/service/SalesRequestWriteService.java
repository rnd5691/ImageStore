package com.imagestore.mypage.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;
import com.imagestore.member.MemberDAO;
import com.imagestore.member.MemberDTO;
import com.imagestore.person.PersonDAO;
import com.imagestore.person.PersonDTO;

public class SalesRequestWriteService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		if(method.equals("GET")){
			HttpSession session = request.getSession();
			PersonDAO personDAO = new PersonDAO();
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
			try {
				PersonDTO personDTO = personDAO.selectOne(memberDTO.getUser_num());
				request.setAttribute("nickname", personDTO.getNickName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/MYPAGE/salesRequestWrite.jsp");
		}
		return actionFoward;
	}

}
