package com.farmer.app.alba.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.farmer.app.alba.vo.AlbaVO;
import com.farmer.app.program.vo.ProgramVO;
import com.farmer.mybatis.config.MyBatisConfig;

public class AlbaDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	SqlSession sqlSession;

	public AlbaDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}

//	전체 아르바이트 목록 출력
	public List<AlbaVO> selectRegistration(Map<String, Integer> pageMap) {
		return sqlSession.selectList("alba.selectRegistration", pageMap);
	}
	
//	전체 아르바이트 개수 조회
	public int selectCount() {
		return sqlSession.selectOne("alba.selectCount");
	}
	
//	진행중인 아르바이트 개수 조회
	public int selectProcess(String today) {
		return sqlSession.selectOne("alba.selectProcess", today);
	}
	
//	조회수
	public void updateViewCount (int albaNumber) {
		sqlSession.update("alba.updateViewCount", albaNumber);
	}

//	클릭한 글 디테일(내용) 조회
	public AlbaVO select(int albaNumber){
		return sqlSession.selectOne("alba.select", albaNumber);
	}
	
//	아르바이트 공고 글 등록
	public void insertAlba(AlbaVO albaVO){
		sqlSession.insert("alba.insertAlba", albaVO);
	}
}
