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
		
		// 게시글 수정 시 파일 삭제
		int fileNo = Integer.parseInt(request.getParameter("fileNo"));
		int postNo  = Integer.parseInt(request.getParameter("postNo"));
		
		postService.deleteFile(fileNo);
		
		// 게시글 가져오기
		Post post = postService.getPost(postNo);
		// 게시글 파일 가져오기
		List<PostFile> fileList = postService.getPostFileList(postNo);

		request.setAttribute("post", post);
		request.setAttribute("fileList", fileList);

		request.getRequestDispatcher("/post/updatePost.jsp").forward(request, response);
	}

}
