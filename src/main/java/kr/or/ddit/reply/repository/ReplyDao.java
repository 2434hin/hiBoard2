package kr.or.ddit.reply.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.reply.model.Reply;

public class ReplyDao implements IReplyDao{

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
	@Override
	public int insertReply(SqlSession sqlSession, Reply reply) {
		return sqlSession.insert("reply.insertReply", reply);
	}

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
	@Override
	public List<Reply> getReplyList(SqlSession sqlSession, int postNo) {
		return sqlSession.selectList("reply.getReplyList", postNo);
	}

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
	@Override
	public int deleteReply(SqlSession sqlSession, int replyNo) {
		return sqlSession.update("reply.deleteReply", replyNo);
	}

}
