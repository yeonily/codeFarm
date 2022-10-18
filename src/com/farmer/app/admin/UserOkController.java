package com.farmer.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.admin.dao.AdminDAO;
import com.farmer.app.member.vo.MemberVO;

public class UserOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		MemberVO memberVO = new MemberVO();
		AdminDAO adminDAO = new AdminDAO();
		
		int memberNumber =  Integer.valueOf(req.getParameter("memberNumber"));
		String memberId = req.getParameter("memberId");
		String memberEmail = req.getParameter("memberEmail");
		String memberPhoneNumber = req.getParameter("memberPhoneNumber");
		String memberName = req.getParameter("memberName");
		int memberGrade = Integer.valueOf(req.getParameter("memberGrade"));
		String memberLocation = req.getParameter("memberLocation");
		
		
		memberVO.setMemberNumber(memberNumber);
		memberVO.setMemberId(memberId);
		memberVO.setMemberEmail(memberEmail);
		memberVO.setMemeberPhoneNumber(memberPhoneNumber);
		memberVO.setMemberName(memberName);
		memberVO.setMemberGrade(memberGrade);
		memberVO.getMemberLocation();
		
		
		return null;
	}
}
