package com.farmer.app.alba;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.alba.dao.AlbaDAO;
import com.farmer.app.alba.vo.AlbaVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AlbaWriteOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		AlbaDAO albaDAO = new AlbaDAO();
		AlbaVO albaVO = new AlbaVO();
		Result result = new Result();
		int currentSequence = 0;
		
//		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "upload/";
		int fileSize = 1024 * 1024 * 5; //5M 
		
//		request 객체, 업로드 할 경로, 파일의 크키, 인코딩 방식, 이름변경정책
//		MultipartRequest multipartRequest = new MultipartRequest(req, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String title = req.getParameter("alba_title");
		String address = req.getParameter("address");
		String albaDay = req.getParameter("aDay_Date");
		String startAlbaDays = req.getParameter("s_startDate");
		String endAlbaDays= req.getParameter("s_endDate");
		String startTime = req.getParameter("s_startTime");
		String endTime = req.getParameter("s_endTime");
		String money = req.getParameter("money_input");
		String applyStartDate = req.getParameter("r_startDate");
		String applyEndDate = req.getParameter("r_endDate");
		String persons = req.getParameter("persons");
		String phone = req.getParameter("phone");
		
		albaVO.setAlbaName(title);
		albaVO.setAlbaLocation(address);
		if (albaDay.equals("")) {
			albaVO.setAlbaStartDate(startAlbaDays);
			albaVO.setAlbaEndDate(endAlbaDays);
		} else {
			albaVO.setAlbaStartDate(albaDay);
			albaVO.setAlbaEndDate(albaDay);
		}
		albaVO.setAlbaStartTime(startTime);
		albaVO.setAlbaEndTime(endTime);
		albaVO.setAlbaFee(money);
		albaVO.setAlbaApplyStartDate(applyStartDate);
		albaVO.setAlbaApplyEndDate(applyEndDate);
		albaVO.setAlbaRecruitedTotalCount(persons);
		albaVO.setAlbaPhoneNumber(phone);
		albaVO.setAlbaImage("test");
		albaVO.setMemberNumber(1);
		
		System.out.println(albaVO);
		albaDAO.insertAlba(albaVO);

		result.setPath("/alba/applyListOk.ab");
		
		return result;
	}
}
