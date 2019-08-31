package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.model.PostFile;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.reply.model.Reply;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;

@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService;
	private IReplyService replyService;

	@Override
	public void init() throws ServletException {
		postService = new PostService();
		replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int postNo = Integer.parseInt(request.getParameter("postNo"));

		// 게시글 가져오기
		Post post = postService.getPost(postNo);
		// 게시글 파일 가져오기
		List<PostFile> fileList = postService.getPostFileList(postNo);
		// 댓글 가져오기
		List<Reply> replyList = replyService.getReplyList(postNo);

		request.setAttribute("post", post);
		request.setAttribute("fileList", fileList);
		request.setAttribute("replyList", replyList);

		request.getRequestDispatcher("/post/post.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
