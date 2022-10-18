package com.farmer.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.member.dao.MemberDAO;

public class CheckEmailOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberEmail = req.getParameter("memberEmail");
		String value = req.getParameter("value");
		System.out.println(memberEmail+"@"+value);
		
			PrintWriter out = resp.getWriter();
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("result", new MemberDAO().checkEmail(memberEmail));
			out.print(jsonObject.toJSONString());
			out.close();
		return null;
	}
}
