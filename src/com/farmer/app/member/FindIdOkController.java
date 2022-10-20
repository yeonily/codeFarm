package com.farmer.app.member;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.member.dao.MemberDAO;
import com.farmer.app.member.vo.MemberVO;

public class FindIdOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		Result result = new Result();
		
		String memberFindId="";
		

		
		System.out.println("fi들어옴2");
		String memberName = req.getParameter("memberName");
		String memberPhoneNumber = req.getParameter("memberPhoneNumber");
		
		memberVO.setMemberName(memberName);
		memberVO.setMemberPhoneNumber(memberPhoneNumber);
		
		System.out.println("fi들어옴3");
		memberFindId=memberDAO.findId(memberVO);	
		System.out.println("fi들어옴4");
		
		req.setAttribute("memberFindId", memberFindId);
		
		System.out.println(memberName);
		System.out.println(memberPhoneNumber);
		System.out.println(memberFindId);
		
		result.setRedirect(true);
		
		

		return result;
	}
}
