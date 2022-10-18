package com.farmer.app.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.farmer.mybatis.config.MyBatisConfig;

public class MemberDAO {
	 SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	   SqlSession sqlSession;
	   
	   public MemberDAO() {
		   sqlSession = sqlSessionFactory.openSession(true);
	}
	   
	   public boolean checkId(String memberId) {
		   return (Integer)sqlSession.selectOne("Member.checkId", memberId)==1;
	   }
	   
	   public boolean checkEmail(String memberEmail) {
		   return (Integer)sqlSession.selectOne("Member.checkEmail", memberEmail)==1;
	   }
	   
	   public boolean checkPhoneNumber(String memberPhoneNumber) {
		   return (Integer)sqlSession.selectOne("Member.checkPhoneNumber", memberPhoneNumber)==1;
	   }
	   
	   
}
