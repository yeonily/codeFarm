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
	   
//	   전체 목록 조회
	   public List<ProgramVO> selectAll(Map<String, Integer> pageMap) {
		   return sqlSession.selectList("program.selectAll", pageMap);
	   }
	   
//	   전체 목록 개수 조회
	   public int selectAllCount() {
		   return sqlSession.selectOne("program.selectAllCount");
	   }
	   
//		진행중인 아르바이트 개수 조회
		public int selectProcess(String today) {
			return sqlSession.selectOne("program.selectProcess", today);
		}
		
//		클릭한 글 내용 조회
		public ProgramVO select(int programNumber){
			return sqlSession.selectOne("program.select", programNumber);
		}
		
//		조회수
		public void updateViewCount(int programNumber) {
			sqlSession.update("program.updateViewCount", programNumber);
		}
}
