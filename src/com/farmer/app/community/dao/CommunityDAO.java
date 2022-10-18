package com.farmer.app.community.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
}