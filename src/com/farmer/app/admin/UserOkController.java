package com.farmer.app.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.admin.dao.AdminDAO;
import com.farmer.app.member.vo.MemberVO;

public class UserOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
//		Result result = new Result();
//		MemberVO memberVO = new MemberVO();
		AdminDAO adminDAO = new AdminDAO();
		PrintWriter out = resp.getWriter();
		
		System.out.println("UserOkController4 들어옴");
		
		JSONArray userList = new JSONArray();
//		forEach를 사용해서 각각의 member객체를 user에 담는다.
		adminDAO.userSelectAll().forEach(memberVO -> {JSONObject user = new JSONObject(memberVO); userList.put(user);});
		out.print(userList.toString());
		out.close();
		System.out.println("UserOkController5 들어옴");
		

		
		
		System.out.println("UserOkController6 들어옴");
		return null;
	}
}
