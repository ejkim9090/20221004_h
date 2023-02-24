package kh.spring.s01.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;

	public List<String> selectList(){
		return sqlSession.selectList("board.list");
	}
	
}
