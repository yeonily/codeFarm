package com.farmer.app.community.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.farmer.app.community.vo.CommunityDTO;
import com.farmer.app.community.vo.CommunityVO;
import com.farmer.mybatis.config.MyBatisConfig;

public class CommunityDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	SqlSession sqlSession;

	public CommunityDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	/* 게시글 작성 */
	public void write(CommunityVO communityVO) {
		sqlSession.insert("Community.write", communityVO);
	}
	
	/* 게시글 전체 개수 */
	public int selectCnt() {
		return sqlSession.selectOne("Community.selectCnt");
	}
	
	/* 검색된 게시글 전체 개수 */
	public int searchCnt(String searchText) {
		return sqlSession.selectOne("Community.searchCnt", searchText);
	}
	
	/* 게시글 전체 목록 */
	public List<CommunityDTO> selectAll(Map<String, Integer> pageMap) {
		return sqlSession.selectList("Community.selectAll", pageMap);
	}
	
	/* 게시글 상세보기 */
	public CommunityDTO select(int communityNumber) {
		return sqlSession.selectOne("Community.select", communityNumber);
	}
	
	/* 게시글 검색 */
	public List<CommunityDTO> SearchTitle(Map<String, Object> pageMap) {
		return sqlSession.selectList("Community.searchTitle", pageMap); 
	}
	
	/* 게시글 조회수 증가 */
	public void updateViewCount(int communityNumber) {
		sqlSession.update("Community.updateViewCount", communityNumber);
	}
	
	/* 가장 최신 게시글 번호 */
	public int selectCurrentSequence() {
		return sqlSession.selectOne("Community.selectCurrentSequence");
	}
}