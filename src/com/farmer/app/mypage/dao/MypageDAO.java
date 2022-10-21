package com.farmer.app.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.farmer.app.alba.vo.AlbaVO;
import com.farmer.app.member.vo.MemberVO;
import com.farmer.app.program.vo.ProgramVO;
import com.farmer.mybatis.config.MyBatisConfig;


public class MypageDAO {
	 SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	   SqlSession sqlSession;
	   
	   public MypageDAO() {
		   sqlSession = sqlSessionFactory.openSession(true);
	   }
	   
	   public MemberVO selectMyPage(int memberNumber){
		   return sqlSession.selectOne("MyPage.selectMyPage", memberNumber);
	   }
	   
	   public void updateMyPage(MemberVO memberVO){
		   sqlSession.update("MyPage.updateMyPage", memberVO);
	   }
	   
	   public void deleteMember(String memberPassword) {
		   sqlSession.delete("MyPage.deleteMember",memberPassword);
	   }
	   
	   public ProgramVO selectThreeProgram(int memberNumber) {
		   return sqlSession.selectOne("MyPage.selectThreePrograms", memberNumber);
	   }
	   
	   public AlbaVO selectThreeAlba(int memberNumber) {
		   return sqlSession.selectOne("MyPage.selectThreeAlbas", memberNumber);
	   }
}
