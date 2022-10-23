package com.farmer.app.memberProgram.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.farmer.app.memberProgram.vo.MemberProgramVO;
import com.farmer.mybatis.config.MyBatisConfig;

public class MemberProgramDAO {
	 SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	   SqlSession sqlSession;
	   
	   public MemberProgramDAO() {
		   sqlSession = sqlSessionFactory.openSession(true);
	}
	   //신청하기
	   public void insert(MemberProgramVO memberProgramVO) {
		   sqlSession.insert("memberProgram.insert", memberProgramVO);
	   }
	   
//		프로그램 신청여부 확인
		public int isApply(Map<String, Integer> userMap) {
			return sqlSession.selectOne("memberProgram.isApply", userMap);
		}
		
		public void applyDelete(int memberNumber) {
			sqlSession.delete("memberProgram.applyDelete", memberNumber);
		}
		
}
