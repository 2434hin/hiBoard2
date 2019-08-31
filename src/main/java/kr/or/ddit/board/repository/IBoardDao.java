package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.user.model.User;

public interface IBoardDao {

	/**
	 *
	 * Method : getBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 목록 조회
	 */
	List<Board> getBoardList(SqlSession sqlSession);

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
	int insertBoard(SqlSession sqlSession, Board board);

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
	int updateBoard(SqlSession sqlSession, Board board);

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
	Board getBoard(SqlSession sqlSession, int boardNo);
}
