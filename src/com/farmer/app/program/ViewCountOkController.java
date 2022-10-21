package com.farmer.app.program;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.program.dao.ProgramDAO;

public class ViewCountOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");//한글 깨짐 방지
		
		HashMap<String, Integer> pageMap = new HashMap<String, Integer>();
		ProgramDAO programDAO = new ProgramDAO();
		PrintWriter out = resp.getWriter();//화면의 body태그 안으로 넣어주기
		
		
		pageMap.put("startRow", 1);
		pageMap.put("rowCount", 12);

		
		
		
		
//		
////		org.json.JSONArray는 String타입의 List만 자동 변환 가능하다.
////		만약 String이 아닌 VO와 같은 클래스타입으로 선언된 List일 경우 직접 JSONObject로 변환 후 JSONArray에 put해주어야 한다.
//		JSONArray programs = new JSONArray();
////		replyDAO.selectAll(boardNumber).forEach(replyVO -> {
////			JSONObject reply = new JSONObject(replyVO);
////			replies.put(reply);
////		});
//		programDAO.selectView(boardNumber).forEach(replyDTO -> {
//			JSONObject reply = new JSONObject(replyDTO); //Object타입으로 변경
//			replies.put(reply); //JSONArray에 put
//		});
//		
//		out.println(replies.toString());
//		out.close();

		return null;
	}
}
