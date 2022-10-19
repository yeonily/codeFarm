package com.farmer.app.program;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.program.dao.ProgramDAO;

public class apply01OkController implements Execute {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProgramDAO programDAO = new ProgramDAO();
		Result result = new Result();
		int programNumber = Integer.valueOf(req.getParameter("programNumber"));

		req.setAttribute("program", programDAO.select(programNumber));
		programDAO.updateViewCount(programNumber);
		
  	  	result.setPath("/app/program/programDetailPage_1.jsp");
		return result;
	}

}



