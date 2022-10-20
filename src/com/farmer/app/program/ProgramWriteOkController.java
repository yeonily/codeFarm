package com.farmer.app.program;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.program.dao.ProgramDAO;
import com.farmer.app.program.vo.ProgramVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProgramWriteOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("들어옴22");
		req.setCharacterEncoding("UTF-8");
		
		ProgramDAO programDAO = new ProgramDAO();
		ProgramVO programVO = new ProgramVO();
		Result result = new Result();
		
		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "upload/program/";
		int fileSize = 1024 * 1024 * 5; //5mb
		
		//request 객체, 업로드할 경로, 파일의 크기, 인코딩 방식, 이름변경정책
//		MultipartRequest multipartRequest = new MultipartRequest(req, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());//업로드됨.
		
		String title = req.getParameter("pro_title");
		String address = req.getParameter("address");
		String startProgramDate = req.getParameter("s_startDate");
		String endProgramDate = req.getParameter("s_endDate");
		String startTime = req.getParameter("s_startTime");
		String endTime = req.getParameter("s_endTime");
		String money = req.getParameter("money_input");
		String applyStartDate = req.getParameter("r_startDate");
		String applyEndDate = req.getParameter("r_endDate");
		String persons = req.getParameter("persons");
		String phone = req.getParameter("phone");
		
		money = (money != null ? money : "0");
		
		programVO.setProgramName(title);
		programVO.setProgramLocation(address);
		programVO.setProgramStartDate(startProgramDate);
		programVO.setProgramEndDate(endProgramDate);
		programVO.setProgramStartTime(startTime);
		programVO.setProgramEndTime(endTime);
		programVO.setProgramFee(money);
		programVO.setProgramApplyStartDate(applyStartDate);
		programVO.setProgramApplyEndDate(applyEndDate);
		programVO.setProgramRecruitedTotalCount(persons);
		programVO.setProgramPhoneNumber(phone);
		programVO.setProgramImage("test");
		programVO.setMemberNumber(1);
		
		
//		programVO.setMemberNumber((Integer)req.getSession().getAttribute("programNumber"));
//		programVO.setProgramImage(multipartRequest.getFilesystemName("1"));
		
		System.out.println(programVO);
		System.out.println(money);
		
		programDAO.insert(programVO);
		result.setPath("/program/applyListOk.pg");
		  
		return result;
	}
}


