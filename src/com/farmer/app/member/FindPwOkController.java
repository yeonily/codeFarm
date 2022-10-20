package com.farmer.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.member.dao.MemberDAO;
import com.farmer.app.member.vo.MemberVO;

public class FindPwOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		
		
		String memberName = req.getParameter("memberName");
		String memberPhoneNumber = req.getParameter("memberPhoneNumber");
		String memberPassword = req.getParameter("memberPassword");
		
		memberVO.setMemberName(memberName);
		memberVO.setMemberPhoneNumber(memberPhoneNumber);
		memberVO.setMemberPassword(memberPassword);
		
		memberDAO.findPassword(memberVO);	
		System.out.println("fi들어옴4");
		
		
		System.out.println(memberName);
		System.out.println(memberPhoneNumber);
		memberVO.setMemberPassword(memberPassword);
		
		
		
		return null;
	}
}
