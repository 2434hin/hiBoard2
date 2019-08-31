package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

@WebServlet("/deletePost")
public class DeletePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService;

	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postNo = Integer.parseInt(request.getParameter("deletePostNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		postService.deletePost(postNo);

		response.sendRedirect(request.getContextPath() + "/boardPost?boardno=" + boardNo);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
