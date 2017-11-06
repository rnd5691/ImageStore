package com.imagestore.mypage.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;
import com.imagestore.member.MemberDTO;
import com.imagestore.person.PersonDAO;

public class MyInfoService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ActionFoward actionFoward = new ActionFoward();
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		if(memberDTO.getKind().equals("person")){
			PersonDAO personDAO = new PersonDAO();
			String artist = null; 
			try {
				artist = personDAO.checkArt(memberDTO.getUser_num());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("artist", artist);
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/MYPAGE/my_info.jsp");
		return actionFoward;
	}

}
