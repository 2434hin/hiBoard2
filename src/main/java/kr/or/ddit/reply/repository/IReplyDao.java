package kr.or.ddit.reply.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.reply.model.Reply;

public interface IReplyDao {

	/**
	 *
	 * Method : insertReply
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param reply
	 * @return
	 * Method 설명 : 댓글 등록
	 */
	int insertReply(SqlSession sqlSession, Reply reply);

	/**
	 *
	 * Method : getReplyList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 번호에 맞는 댓글 조회
	 */
	List<Reply> getReplyList(SqlSession sqlSession, int postNo);

	/**
	 *
	 * Method : deleteReply
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param replyNo
	 * @return
	 * Method 설명 : 댓글 삭제
	 */
	int deleteReply(SqlSession sqlSession, int replyNo);

}
