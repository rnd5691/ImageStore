package com.imagestore.sales;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;

public class SalesRequestNowService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ActionFoward actionFoward = new ActionFoward();
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/sales/salesRequestNow.jsp");
		
		return actionFoward;
	}

}
