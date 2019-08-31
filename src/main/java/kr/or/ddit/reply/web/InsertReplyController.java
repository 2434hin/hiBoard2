package kr.or.ddit.reply.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.reply.model.Reply;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.user.model.User;

@WebServlet("/insertReply")
public class InsertReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IReplyService replyService;

	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int postNo = Integer.parseInt(request.getParameter("postNo"));	// 게시글 번호
		String postReply = request.getParameter("postReply");				// 댓글 내용

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("S_USERVO");

		String userId = user.getUserId();	// 작성자

		Reply reply = new Reply(postNo, postReply, userId);

		int insertCnt = replyService.insertReply(reply);

		// 댓글 등록 성공 시
		if(insertCnt > 0) {
			response.sendRedirect(request.getContextPath() + "/post?postNo=" + postNo);
		}
	}

}
