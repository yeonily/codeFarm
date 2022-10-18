package com.farmer.app.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.member.vo.MemberVO;
import com.farmer.app.mypage.dao.MypageDAO;

public class MyPageOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MypageDAO mypageDAO = new MypageDAO();
		MemberVO memberVO = new MemberVO();
		Result result = new Result();
		
//		System.out.println(mypageDAO.selectMyPage(2));
		memberVO = mypageDAO.selectMyPage(2);
		
		String memberName = memberVO.getMemberName();
		String memberLocation = memberVO.getMemberLocation();
		int memberGrade = memberVO.getMemberGrade();
		
		System.out.println(memberName);
		System.out.println(memberLocation);
		System.out.println(memberGrade);
		
		req.setAttribute("memberName", memberName);
		req.setAttribute("memberLocation", memberLocation);
		req.setAttribute("memberGrade", memberGrade);
		
		
		return result;
	}
}
