package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.board.repository.IBoardDao;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class BoardService implements IBoardService {

	private IBoardDao boardDao;

	public BoardService() {
		boardDao = new BoardDao();
	}

	/**
	 *
	 * Method : getBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 목록 조회
	 */
	public List<Board> getBoardList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Board> boardList = boardDao.getBoardList(sqlSession);
		sqlSession.close();

		return boardList;
	}

	/**
	 *
	 * Method : insertBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param board
	 * @return
	 * Method 설명 : 게시판 생성
	 */
	@Override
	public int insertBoard(Board board) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = boardDao.insertBoard(sqlSession, board);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	/**
	 *
	 * Method : updateBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param board
	 * @return
	 * Method 설명 : 게시판 사용 수정
	 */
	@Override
	public int updateBoard(Board board) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateBoard = boardDao.updateBoard(sqlSession, board);
		sqlSession.commit();
		sqlSession.close();
		return updateBoard;
	}

	/**
	 *
	 * Method : getBoard
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param boardNo
	 * @return
	 * Method 설명 : 게시판 번호에 맞는 게시판 조회
	 */
	@Override
	public Board getBoard(int boardNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Board board = boardDao.getBoard(sqlSession, boardNo);
		sqlSession.close();

		return board;
	}
}
