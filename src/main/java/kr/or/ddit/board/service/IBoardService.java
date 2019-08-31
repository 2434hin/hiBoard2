package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;

public interface IBoardService {

	/**
	 *
	 * Method : getBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 목록 조회
	 */
	public List<Board> getBoardList();

	/**
	 *
	 * Method : insertBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param board
	 * @return
	 * Method 설명 : 게시판 생성
	 */
	int insertBoard(Board board);

	/**
	 *
	 * Method : updateBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param board
	 * @return
	 * Method 설명 : 게시판 사용 수정
	 */
	int updateBoard(Board board);

	/**
	 *
	 * Method : getBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param boardNo
	 * @return
	 * Method 설명 : 게시판 번호에 맞는 게시판 조회
	 */
	public Board getBoard(int boardNo);
}
