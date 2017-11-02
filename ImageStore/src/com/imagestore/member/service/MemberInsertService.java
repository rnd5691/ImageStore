package com.imagestore.member.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;
import com.imagestore.company.CompanyDAO;
import com.imagestore.company.CompanyDTO;
import com.imagestore.member.MemberDAO;
import com.imagestore.member.MemberDTO;
import com.imagestore.person.PersonDAO;
import com.imagestore.person.PersonDTO;
import com.imagestore.util.DBConnector;

public class MemberInsertService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		ActionFoward actionFoward = new ActionFoward();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String kind = request.getParameter("kind");
		System.out.println("id : "+id+", pw : "+pw+", phone : "+phone+", email : "+email+", kind : "+kind);
		Connection con = null;
		MemberDAO memberDAO = new MemberDAO();
		int result = 0;
		
		try{
			con = DBConnector.getConnect();
			con.setAutoCommit(false);
			MemberDTO memberDTO = new MemberDTO();
			
			memberDTO.setId(id);
			memberDTO.setPw(pw);
			memberDTO.setPhone(phone);
			memberDTO.setEmail(email);
			memberDTO.setKind(kind);

			result = memberDAO.insert(memberDTO, con);
			
			int user_num = memberDAO.searchUserNum(memberDTO, con);
			
			if(kind.equals("company")){
				CompanyDTO companyDTO = new CompanyDTO();
				CompanyDAO companyDAO = new CompanyDAO();
				
				
				companyDTO.setCompany_name(request.getParameter("company_name"));
				companyDTO.setUser_num(user_num);
				companyDTO.setCompany_num(request.getParameter("company_num"));
				companyDTO.setCompany_phone(request.getParameter("company_phone"));
				
				result = companyDAO.insert(companyDTO, con);
				
				con.commit();
			}else{
				PersonDTO personDTO = new PersonDTO();
				PersonDAO personDAO = new PersonDAO();
				
				personDTO.setNickName(request.getParameter("nickname"));
				personDTO.setUser_num(user_num);
				personDTO.setName(request.getParameter("name"));
				personDTO.setBirth(Date.valueOf(request.getParameter("birth")));
				personDTO.setArtist(request.getParameter("artist"));
				
				/*System.out.println(personDTO.getNickName());
				System.out.println(personDTO.getUser_num());
				System.out.println(personDTO.getName());
				System.out.println(personDTO.getBirth());*/
				System.out.println(personDTO.getArtist());
				
				result = personDAO.insert(personDTO, con);
				
				con.commit();
			}
		}catch(Exception e){
			con.rollback();
			e.printStackTrace();
		}finally {
			con.setAutoCommit(true);
		}
		
		if(result>0){
			request.setAttribute("message", "회원 가입에 성공 하셨습니다.");
		}else{
			request.setAttribute("message", "회원 가입에 실패 하셨습니다.");
		}
		request.setAttribute("path", "../index.jsp");
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		
		return actionFoward;
	}

}
