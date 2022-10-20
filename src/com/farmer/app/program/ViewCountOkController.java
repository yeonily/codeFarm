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
		
		
		
//		페이지
		String temp = req.getParameter("page");//현재 페이지
		int page = temp == null ? 1 : Integer.parseInt(temp);//디폴트는 1페이지
		
		int total = programDAO.selectAllCount();//전체 게시글 개수
//		한 페이지에 출력되는 게시글의 개수
		int rowCount = 12;//몇 개 게시글을 보여줄거니?
//		한 페이지에 나오는 페이지 버튼의 개수
		int pageCount = 10;//한 화면에 나오는 페이지 버튼 개수 
		int startRow = (page - 1) * rowCount;
		
		int endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount);//단위에서 마지막 페이지
		int startPage = endPage - (pageCount - 1); //단위에서 첫번째 페이지
		int realEndPage = (int)Math.ceil(total / (double)rowCount); 
		
		boolean prev = startPage > 1; //이전페이지 보이기
		endPage = endPage > realEndPage ? realEndPage : endPage;
		boolean next = endPage != realEndPage; //다음페이지 보이기
		
		pageMap.put("startRow", startRow);
		pageMap.put("rowCount", rowCount);
		
        // 현재 날짜/시간
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        // 포맷팅 적용
        String fToday = f.format(today);
        
        req.setAttribute("processCount", programDAO.selectProcess(fToday));
		req.setAttribute("programs", programDAO.selectAll(pageMap));
		req.setAttribute("totalCount", total);
		req.setAttribute("page", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("realEndPage", realEndPage);
		req.setAttribute("prev", prev);
		req.setAttribute("next", next);
		
		
		
		
//		
////		org.json.JSONArray는 String타입의 List만 자동 변환 가능하다.
////		만약 String이 아닌 VO와 같은 클래스타입으로 선언된 List일 경우 직접 JSONObject로 변환 후 JSONArray에 put해주어야 한다.
//		JSONArray replies = new JSONArray();
////		replyDAO.selectAll(boardNumber).forEach(replyVO -> {
////			JSONObject reply = new JSONObject(replyVO);
////			replies.put(reply);
////		});
//		replyDAO.selectAll(boardNumber).forEach(replyDTO -> {
//			JSONObject reply = new JSONObject(replyDTO); //Object타입으로 변경
//			replies.put(reply); //JSONArray에 put
//		});
//		
//		out.println(replies.toString());
//		out.close();

		return null;
	}
}
