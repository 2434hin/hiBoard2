package kr.or.ddit.reply.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.PostFile;
import kr.or.ddit.reply.model.Reply;
import kr.or.ddit.reply.repository.IReplyDao;
import kr.or.ddit.reply.repository.ReplyDao;
import kr.or.ddit.util.MybatisUtil;

public class ReplyService implements IReplyService{

	private IReplyDao replyDao;

	public ReplyService() {
		replyDao = new ReplyDao();
	}

	/**
	 *
	 * Method : insertReply
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param reply
	 * @return
	 * Method 설명 : 댓글 등록
	 */
	@Override
	public int insertReply(Reply reply) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = replyDao.insertReply(sqlSession, reply);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	/**
	 *
	 * Method : getReplyList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 번호에 맞는 댓글 조회
	 */
	@Override
	public List<Reply> getReplyList(int postNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Reply> replyList = replyDao.getReplyList(sqlSession, postNo);
		sqlSession.close();

		return replyList;
	}

	/**
	 *
	 * Method : deleteReply
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param replyNo
	 * @return
	 * Method 설명 : 댓글 삭제
	 */
	@Override
	public int deleteReply(int replyNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteReply = replyDao.deleteReply(sqlSession, replyNo);
		sqlSession.commit();
		sqlSession.close();
		return deleteReply;
	}
}
