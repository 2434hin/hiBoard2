package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.model.Reply;

public interface IReplyService {

	/**
	 *
	 * Method : insertReply
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param reply
	 * @return
	 * Method 설명 : 댓글 등록
	 */
	int insertReply(Reply reply);

	/**
	 *
	 * Method : getReplyList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 번호에 맞는 댓글 조회
	 */
	List<Reply> getReplyList(int postNo);

	/**
	 *
	 * Method : deleteReply
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param replyNo
	 * @return
	 * Method 설명 : 댓글 삭제
	 */
	int deleteReply(int replyNo);

}
