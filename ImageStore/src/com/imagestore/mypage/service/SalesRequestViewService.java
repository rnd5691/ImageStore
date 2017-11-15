package com.imagestore.mypage.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;
import com.imagestore.file.FileDAO;
import com.imagestore.file.FileDTO;
import com.imagestore.util.DBConnector;
import com.imagestore.work.WorkDAO;
import com.imagestore.work.WorkDTO;

public class SalesRequestViewService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ActionFoward actionFoward = new ActionFoward();
		WorkDAO workDAO = new WorkDAO();
		int work_seq = Integer.parseInt(request.getParameter("work_seq"));
		System.out.println("뷰 seq : "+work_seq);
		WorkDTO workDTO = null;
		FileDTO fileDTO = null;
		Connection con = null;
			try{
				con = DBConnector.getConnect();
				con.setAutoCommit(false);
				workDTO = workDAO.selectOne(work_seq, con);
				FileDAO fileDAO = new FileDAO();
				fileDTO = fileDAO.selectOne(work_seq, con);
				System.out.println("파일DTO : "+fileDTO);
			
				
				con.commit();
			}catch(Exception e){
				e.printStackTrace();
				con.rollback();
			} finally {
				con.setAutoCommit(true);
				con.close();
			}
			
			request.setAttribute("file", fileDTO);
			request.setAttribute("work", workDTO);
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/MYPAGE/salesRequestView.jsp");
		
		return actionFoward;
	}
}
