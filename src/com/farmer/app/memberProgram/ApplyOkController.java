package com.farmer.app.memberProgram;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.memberProgram.dao.MemberProgramDAO;
import com.farmer.app.memberProgram.vo.MemberProgramVO;

public class ApplyOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MemberProgramDAO memberProgramDAO = new MemberProgramDAO();
		MemberProgramVO memberProgramVO = new MemberProgramVO();
		Result result = new Result();
		
		memberProgramVO.setMemberNumber((Integer)req.getSession().getAttribute("memberNumber"));
		memberProgramVO.setMemberName(req.getParameter("userName"));
		memberProgramVO.setMemberGender(req.getParameter("userGender"));
		memberProgramVO.setMemberBirth(req.getParameter("userBirth"));
		memberProgramVO.setMemberPhoneNumber(req.getParameter("userPhone"));
		memberProgramVO.setMemberAddress(req.getParameter("userAddress"));
		memberProgramVO.setMemberEmail(req.getParameter("userEmail"));
		memberProgramVO.setMemberReason(req.getParameter("userReason"));
		
		memberProgramDAO.insert(memberProgramVO);
	    
	    result.setPath("/program/apply03.pg");
	      
	    return result;

	}
}

