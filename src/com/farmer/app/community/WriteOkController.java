package com.farmer.app.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.community.dao.CommunityDAO;
import com.farmer.app.community.vo.CommunityVO;

public class WriteOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		CommunityDAO communityDAO = new CommunityDAO();
		CommunityVO communityVO = new CommunityVO();
		Result result = new Result();
		
		communityVO.setCommunityTitle(req.getParameter("nttSj"));
		communityVO.setCommunityContent(req.getParameter("summernote"));
		communityVO.setMemberNumber(1); // 이후에 session에 저장된 회원번호로 변경해야함
		
		communityDAO.write(communityVO);
		result.setPath("/community/listOk.cm");
		return result;
	}
}
