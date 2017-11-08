package com.imagestore.mypage.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;
import com.imagestore.file.FileDAO;
import com.imagestore.file.FileDTO;
import com.imagestore.work.WorkDAO;
import com.imagestore.work.WorkDTO;

public class SalesRequestViewService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ActionFoward actionFoward = new ActionFoward();
		WorkDAO workDAO = new WorkDAO();
		int work_seq = Integer.parseInt(request.getParameter("work_seq"));
		
		WorkDTO workDTO = null;
		FileDTO fileDTO = null;
		try{
			workDTO = workDAO.selectOne(work_seq);
			FileDAO fileDAO = new FileDAO();
			fileDTO = fileDAO.selectOne(workDTO.getFile_num());
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("file", fileDTO);
		request.setAttribute("work", workDTO);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/MYPAGE/salesRequestView.jsp");
		
		return actionFoward;
	}

}
