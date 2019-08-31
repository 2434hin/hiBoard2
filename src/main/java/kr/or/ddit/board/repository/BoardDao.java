package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.user.model.User;

public class BoardDao implements IBoardDao {

	/**
	 *
	 * Method : getBoardList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 게시판 전체 목록 조회
	 */
	@Override
	public List<Board> getBoardList(SqlSession sqlSession) {
		return sqlSession.selectList("board.getBoardList");
	}

	/**
	 *
	 * Method : insertBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param board
	 * @return
	 * Method 설명 : 게시판 생성
	 */
	@Override
	public int insertBoard(SqlSession sqlSession, Board board) {
		return sqlSession.insert("board.insertBoard", board);
	}

	/**
	 *
	 * Method : updateBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param board
	 * @return
	 * Method 설명 : 게시판 사용 수정
	 */
	@Override
	public int updateBoard(SqlSession sqlSession, Board board) {
		return sqlSession.update("board.updateBoard", board);
	}

	/**
	 *
	 * Method : getBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 * Method 설명 : 게시판 번호에 맞는 게시판 조회
	 */
	@Override
	public Board getBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("board.getBoard", boardNo);
	}


}
