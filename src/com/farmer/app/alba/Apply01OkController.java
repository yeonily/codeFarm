package com.farmer.app.alba;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.alba.dao.AlbaDAO;
import com.farmer.app.program.dao.ProgramDAO;

public class Apply01OkController implements Execute {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AlbaDAO albaDAO = new AlbaDAO();
		Result result = new Result();
		int albaNumber = Integer.valueOf(req.getParameter("albaNumber"));

		req.setAttribute("alba", albaDAO.select(albaNumber));
		albaDAO.updateViewCount(albaNumber);
		
  	  	result.setPath("/app/alba/albaDetailPage_1.jsp");
		return result;
	}

}
