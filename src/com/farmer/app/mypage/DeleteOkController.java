package com.farmer.app.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ant.SessionsTask;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.member.dao.MemberDAO;
import com.farmer.app.member.vo.MemberVO;
import com.farmer.app.mypage.dao.MypageDAO;
import com.mysql.cj.Session;

public class DeleteOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Result result = new Result();
		MemberVO memberVO = new MemberVO();
		MypageDAO mypageDAO = new MypageDAO();
		PrintWriter out = resp.getWriter();
		
		
		String inputPassword = req.getParameter("inputPassword");
		mypageDAO.deleteMember(inputPassword);
		out.print("test");
		
		return result;
	}
}
