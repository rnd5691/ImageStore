package com.imagestore.search;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;
import com.imagestore.file.FileDAO;
import com.imagestore.file.FileDTO;
import com.imagestore.util.DBConnector;
import com.imagestore.work.WorkDAO;
import com.imagestore.work.WorkDTO;

public class SearchService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		WorkDAO workDAO = new WorkDAO();
		
		String search = request.getParameter("search");
		int perPage = Integer.parseInt(request.getParameter("perPage"));
		String select = request.getParameter("select");
		String kind = request.getParameter("kind");
		String check = request.getParameter("check");
		
		List<WorkDTO> ar = null;
		List<FileDTO> fileName = null;
		try {
			Connection con = DBConnector.getConnect();
			con.setAutoCommit(false);
			ar = workDAO.selectAll(con);
			
			for(int i=0; i<ar.size(); i++) {
				String[] tag = ar.get(i).getTag().split(",");
				for(int j=0; j<tag.length; j++) {
					System.out.println("tag["+j+"]"+tag[j]);
					if(tag[j].trim().equals(search)) {
						fileName = workDAO.seachWorkSEQ(con, tag[j]);
					}
				}
			}
			/*ar = fileDAO.fileSelectAll();//파일 데이터들을 가져옴*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("author", fileName);
		request.setAttribute("file", ar);
		request.setAttribute("search", search);
		request.setAttribute("perPage", perPage);
		request.setAttribute("select", select);
		request.setAttribute("kind", kind);
		request.setAttribute("check", check);
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/search/searchList.jsp");
		return actionFoward;
	}

}
