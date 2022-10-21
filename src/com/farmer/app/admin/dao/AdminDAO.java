package com.farmer.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.farmer.app.admin.vo.AdminAlbaVO;
import com.farmer.app.admin.vo.AdminCommunityVO;
import com.farmer.app.admin.vo.AdminMentorVO;
import com.farmer.app.admin.vo.AdminProgramVO;
import com.farmer.app.admin.vo.AdminReplyVO;
import com.farmer.app.alba.vo.AlbaVO;
import com.farmer.app.member.vo.MemberVO;
import com.farmer.app.program.vo.ProgramVO;
import com.farmer.mybatis.config.MyBatisConfig;

public class AdminDAO {
		SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	   SqlSession sqlSession;

	   public AdminDAO() {
		   sqlSession = sqlSessionFactory.openSession(true);
	   }
	   
//	   전체 회원 정보 목록 보여주기 (유저관리)
	   public List<MemberVO> userSelectAll(Map<String, Integer> pageMap) {
		   return sqlSession.selectList("Admin.userSelectAll", pageMap);
	   }
	   
//	   전체 회원 수 (유저관리)
	   public int selectCount() {
		   return sqlSession.selectOne("Admin.selectCount");
	   }
	   
//	   회원 탈퇴 시키기 (유저관리)
	   public void delete(int memberNumber) {
		   sqlSession.delete("Admin.delete", memberNumber);
	   }
	   
//	   프로그램 지원자 목록 보여주기(농촌 프로그램 지원자 관리)
	   public List<AdminProgramVO> programSelectAll(Map<String, Integer> pageMap){
		   return sqlSession.selectList("Admin.programSelectAll", pageMap);
	   }
	   
//	   총 지원자 수 (농촌 프로그램 지원자 관리)
	   public int selectIdCount() {
		   return sqlSession.selectOne("Admin.selectIdCount");
	   }
	   
//	   프로그램 글 목록 보여주기(농촌 프로그램 글 관리)
	   public List<ProgramVO> programListAll(Map<String, Integer> pageMap){
		   return sqlSession.selectList("Admin.programListAll", pageMap);
	   }
	   
//	   프로그램 수
	   public int selectProgramCount() {
		   return sqlSession.selectOne("Admin.selectProgramCount");
	   }
	   
//	   프로그램 삭제 시키기 (농촌 프로그램 글 관리)
	   public void deleteProgram(int programNumber) {
		   sqlSession.delete("Admin.deleteProgram", programNumber);
	   }
	   
	   public List<AdminAlbaVO> albaUserSelectAll(Map<String, Integer> pageMap){
		   return sqlSession.selectList("Admin.albaUserSelectAll", pageMap);
	   }
	   
	   public int selectIdCounta() {
		   return sqlSession.selectOne("Admin.selectIdCounta");
	   }
	   
//	   프로그램 글 목록 보여주기(농촌 프로그램 글 관리)
	   public List<AlbaVO> albaListAll(Map<String, Integer> pageMap){
		   return sqlSession.selectList("Admin.albaListAll", pageMap);
	   }
	   
//	   알바 수
	   public int selectAlbaCount() {
		   return sqlSession.selectOne("Admin.selectAlbaCount");
	   }
	   
//	   프로그램 삭제 시키기 (농촌 프로그램 글 관리)
	   public void deleteAlba(int albaNumber) {
		   sqlSession.delete("Admin.deleteAlba", albaNumber);
	   }
	   
//	   멘토 리스트 (멘토 홍보 관리)
	   public List<AdminMentorVO> mentorList(Map<String, Integer> pageMap){
		   return sqlSession.selectList("Admin.mentorList", pageMap);
	   }

//	   멘토 홍보 글 수 count(멘토 홍보 관리)
	   public int mentorCount() {
		   return sqlSession.selectOne("Admin.mentorCount");
	   }
	   
//	   멘토 목록 삭제 시키기 (멘토 홍보 관리)
	   public void deleteMentor(int mentorNumber) {
		   sqlSession.delete("Admin.deleteMentor", mentorNumber);
	   }
	   
//	   소통공간 리스트 (소통공간 관리)
	   public List<AdminCommunityVO> communityList(Map<String, Integer> pageMap){
		   return sqlSession.selectList("Admin.communityList", pageMap);
	   }
	   
//	   소통공간 글 목록 수 (소통공간 관리)
	   public int communityCount() {
		   return sqlSession.selectOne("Admin.communityCount");
	   }
	   
//	   소통공간 글 삭제 시키기 (멘토 홍보 관리)
	   public void deleteCommunity(int CommunityNumber) {
		   sqlSession.delete("Admin.deleteCommunity", CommunityNumber);
	   }
	   
//	   댓글 목록 불러오기 (댓글관리)
	   public List<AdminReplyVO> replyList(Map<String, Integer> pageMap){
		   return sqlSession.selectList("Admin.replyList", pageMap);
	   }
	   
//	   댓글 목록 수 (댓글 관리)
	   public int replyCount() {
		   return sqlSession.selectOne("Admin.replyCount");
	   }
	   
//	   댓글 삭제 시키기 (멘토 홍보 관리)
	   public void deleteReply(int replyNumber) {
		   sqlSession.delete("Admin.deleteReply", replyNumber);
	   }
}

