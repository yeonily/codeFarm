package com.farmer.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.farmer.app.member.vo.MemberVO;
import com.farmer.mybatis.config.MyBatisConfig;

public class AdminDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	   SqlSession sqlSession;
	   
	   public AdminDAO() {
		   sqlSession = sqlSessionFactory.openSession(true);
		   System.out.println("AdminDAO1 들어옴");
	   }
	   
	   public List<MemberVO> userSelectAll(MemberVO memberVO) {
		   System.out.println("AdminDAO2 들어옴");
		   return sqlSession.selectList("Admin.userSelectAll", memberVO);
	   }
}

