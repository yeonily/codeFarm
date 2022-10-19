package com.farmer.app.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.member.vo.MemberVO;
import com.farmer.app.mypage.dao.MypageDAO;

public class UpdateOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Result result = new Result();
		MypageDAO mypageDAO = new MypageDAO();
		MemberVO memberVO = new MemberVO();
		
		System.out.println("들어옴");
		String type = req.getParameter("grade");
		String password = req.getParameter("password");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("inputPhone");
		String location1 = req.getParameter("userInfo01");
		String location2 = req.getParameter("userInfo02");
		String location = location1 + " " +location2;
		
		memberVO.setMemberGrade(0);
		memberVO.setMemberPassword(password);
		memberVO.setMemberId(id);
		memberVO.setMemberName(name);
		
		System.out.println(type);
		System.out.println(password);
		System.out.println(id);
		System.out.println(name);
		System.out.println(email);
		System.out.println(phoneNumber);
		System.out.println(location);
		
		return result;
	}
}
