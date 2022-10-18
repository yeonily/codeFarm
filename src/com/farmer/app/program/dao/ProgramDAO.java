package com.farmer.app.program.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.farmer.app.program.vo.ProgramVO;
import com.farmer.mybatis.config.MyBatisConfig;

public class ProgramDAO {
	 SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	   SqlSession sqlSession;
	   
	   public ProgramDAO() {
		   sqlSession = sqlSessionFactory.openSession(true);
	   }
	   
	   public List<ProgramVO> selectAll(Map<String, Integer> pageMap) {
		   return sqlSession.selectList("Program.selectAll", pageMap);
	   }
	   
	   public int selectAllCount() {
		   return sqlSession.selectOne("Program.selectAllCount");
	   }
}
