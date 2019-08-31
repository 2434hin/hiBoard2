package kr.or.ddit.reply.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {

	private int replytno;			// 댓글 번호
	private int postno;				// 게시글 번호
	private String replycontent;	// 댓글 내용
	private String userid;			// 작성자
	private Date replywdate;		// 작성일시
	private int deleteyn;			// 삭제여부 (삭제안함 0, 삭제 1)

	public Reply() { }

	// 댓글 생성
	public Reply(int postNo, String postReply, String userId) {
		this.postno = postNo;
		this.replycontent = postReply;
		this.userid = userId;
	}
	public int getReplytno() {
		return replytno;
	}
	public void setReplytno(int replytno) {
		this.replytno = replytno;
	}
	public int getPostno() {
		return postno;
	}
	public void setPostno(int postno) {
		this.postno = postno;
	}
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getReplywdate() {
		return replywdate;
	}
	public String getReplywdateFmt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(replywdate);
	}
	public void setReplywdate(Date replywdate) {
		this.replywdate = replywdate;
	}
	public int getDeleteyn() {
		return deleteyn;
	}
	public void setDeleteyn(int deleteyn) {
		this.deleteyn = deleteyn;
	}


}
