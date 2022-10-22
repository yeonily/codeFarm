package com.farmer.app.community;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.community.dao.CommunityDAO;

public class SearchOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String filter = req.getParameter("searchSelect"); // 셀렉트 박스에서 선택한 값
		String filter2 = req.getParameter("firstFilter");
		String searchText = "%" + req.getParameter("programSearch") + "%"; // 사용자가 검색창에 입력한 값
		
		
		HashMap<String, Object> pageMap = new HashMap<String, Object>();
		CommunityDAO communityDAO = new CommunityDAO();
		Result result = new Result();
		String temp = req.getParameter("page");
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		int total = communityDAO.searchCnt(searchText);
		int rowCount = 10, pageCount = 10;
		int startRow = (page - 1) * rowCount;
		
		int endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);
		int realEndPage = (int)Math.ceil(total / (double)pageCount);
		
		boolean prev = startPage > 1; 
		endPage = endPage > realEndPage ? realEndPage : endPage;
		boolean next = endPage != realEndPage;
		
		/* 첫 번째 필터 검색 후 기존 필터 검색 조건을 유지하기 위함 */
		if(filter == null) {
			filter = filter2;
		}
		
		pageMap.put("startRow", startRow);
		pageMap.put("rowCount", rowCount);
		pageMap.put("searchText", searchText);
//		pageMap.put("filter", filter);
		
		System.out.println("filter1 : " + filter);
		System.out.println("filter2 : " + filter2);
		
		switch (filter) {
		case "sj": // 만약 제목을 선택하고 값을 입력했을 시
			req.setAttribute("boards", communityDAO.SearchTitle(pageMap));
			req.setAttribute("total", total);
			req.setAttribute("page", page);
			req.setAttribute("startPage", startPage);
			req.setAttribute("endPage", endPage);
			req.setAttribute("realEndPage", realEndPage);
			req.setAttribute("prev", prev);
			req.setAttribute("next", next);
			req.setAttribute("searchText", searchText);
			req.setAttribute("filter", filter);
			break;

		case "cn": // 만약 내용을 선택하고 값을 입력했을 시
			req.setAttribute("filter", filter);
			break;

		case "cnsj": // 만약 제목+내용을 선택하고 값을 입력했을 시
			req.setAttribute("filter", filter);
			break;
			
		case "nm": // 만약 작성자를 선택하고 값을 입력했을 시
			req.setAttribute("filter", filter);
			break;
			
		
			
			
		default:
			break;
		}
				
		result.setPath("/app/community/comm_list_result.jsp");
		return result;
	}
}
