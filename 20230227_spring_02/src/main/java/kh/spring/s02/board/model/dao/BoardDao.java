package kh.spring.s02.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kh.spring.s02.board.model.vo.BoardVo;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession aa;
	
	public int insert(BoardVo vo) {
		return aa.insert("boardns.insertid", vo);		
	}
	public int update(BoardVo vo) {
		return aa.update("boardns.updateid", vo);		
	}
	public int updateReadCount(int boardNum) {
		return aa.update("boardns.updateReadCount", boardNum);		
	}
	public int updateForReply(int boardNum) {
		return aa.update("boardns.updateForReply", boardNum);		
	}
	public int delete(int boardNum  /* BoardVo vo 또는 PK 또는 List<PK>*/) {
		return aa.delete("boardns.insertid", boardNum);		
	}
	public BoardVo selectOne(int boardNum /* PK */) {
		return aa.selectOne("boardns.selectOneid", boardNum);		
	}
	public List<BoardVo> selectList() {
		return aa.selectList("boardns.selectListid");		
	}
	public int selectOneCount() {
		return aa.selectOne("boardns.selectOneCount");
	}
	
	/*
	 * public BoardVo selectList2() { return
	 * sqlSession.selectOne("boardns.selectListid2"); }
	 */
}
