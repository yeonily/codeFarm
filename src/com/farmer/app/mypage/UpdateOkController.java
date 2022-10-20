package com.farmer.app.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Execute;
import com.farmer.app.Result;
import com.farmer.app.member.dao.MemberDAO;
import com.farmer.app.member.vo.MemberVO;
import com.farmer.app.mypage.dao.MypageDAO;

public class UpdateOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Result result = new Result();
		MypageDAO mypageDAO = new MypageDAO();
		MemberVO memberVO = new MemberVO();
		
		int memberGrade;
		String memberType;
		String mentorType;
		String gradeType = req.getParameter("grade");
		String memberPassword = req.getParameter("password");
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		String memberPhoneNumber = req.getParameter("inputPhone");
		String location1 = req.getParameter("userInfo01");
		String location2 = req.getParameter("userInfo02");
		String memberLocation = location1 + " " +location2;
		String memberEmail = email1 + "@" + email2;
		
		
//		정보수정 일반사용자 버튼 클릭 value가 user
		if(gradeType.equals("user")) {
			memberGrade = 1;
		}else {
			memberGrade = -1;
		}
		
		memberVO.setMemberNumber(2);
		memberVO.setMemberGrade(memberGrade);
		memberVO.setMemberPassword(memberPassword);
		memberVO.setMemberEmail(memberEmail);
		memberVO.setMemberPhoneNumber(memberPhoneNumber);
		memberVO.setMemberLocation(memberLocation);
		
		mypageDAO.updateMyPage(memberVO);
		
////		가입 형태 검사
		if(memberGrade < 0) {
			memberType = "농장주";
			req.setAttribute("memberType", memberType);
		}else if(memberGrade == 0) {
			memberType = "관리자";
			req.setAttribute("memberType", memberType);
		}else if(memberGrade == 1) {
			memberType = "일반 사용자";
			req.setAttribute("memberType", memberType);
		}else {
			memberType = "비정상 가입자";
			req.setAttribute("memberType", memberType);
		}
//
//		멘토링 검사
		if(memberGrade != -1) {
			mentorType = "X";
			req.setAttribute("mentorType", mentorType);
		}else {
			if(memberVO == null) {
				mentorType = "X";
				req.setAttribute("mentorType", mentorType);
			}else{
				mentorType = "멘토";
				req.setAttribute("mentorType", mentorType);
			}
		}
		
		req.setAttribute("memberLocation", memberLocation);	
		
		return result;
	}
}
