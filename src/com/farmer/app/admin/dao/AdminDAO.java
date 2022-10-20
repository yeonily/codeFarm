package com.farmer.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.farmer.app.member.vo.MemberVO;
import com.farmer.app.program.vo.ProgramVO;
import com.farmer.mybatis.config.MyBatisConfig;

public class AdminDAO {
		SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	   SqlSession sqlSession;

	   public AdminDAO() {
		   sqlSession = sqlSessionFactory.openSession(true);
	   }
	   
	   
	   public List<MemberVO> userSelectAll(Map<String, Integer> pageMap) {
		   return sqlSession.selectList("Admin.userSelectAll", pageMap);
	   }
	   
	   public int selectCount() {
		   return sqlSession.selectOne("Admin.selectCount");
	   }
	   
	   public void delete(int memberNumber) {
		   sqlSession.delete("Admin.delete", memberNumber);
	   }
	   
	   public int selectIdCount() {
		   return sqlSession.selectOne("Admin.selectIdCount");
	   }
	   
	   public List<ProgramVO> programSelectAll(Map<String, Integer> pageMap){
		   return sqlSession.selectList("Admin.programSelectAll", pageMap);
	   }
}

