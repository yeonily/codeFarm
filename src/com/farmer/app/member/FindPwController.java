package com.farmer.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.member.dao.MemberDAO;
import com.farmer.app.member.vo.MemberVO;

public class FindPwController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();

		String memberId = req.getParameter("inputId");
		String memberPhoneNumber = req.getParameter("inputPhoneNumber");
		String memberPassword = req.getParameter("password");
				
		memberVO.setMemberName(memberId);
		memberVO.setMemberPhoneNumber(memberPhoneNumber);
		
		memberDAO.findPassword(memberVO);	
		
		memberVO.setMemberPassword(memberPassword);
				
		System.out.println(memberId);
		System.out.println(memberPhoneNumber);
				
		return null;
	}
}
