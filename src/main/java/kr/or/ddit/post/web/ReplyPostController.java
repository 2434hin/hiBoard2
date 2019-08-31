package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/replyPost")
public class ReplyPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNo = request.getParameter("postNo");
		String boardNo = request.getParameter("boardNo");
		String postGn = request.getParameter("postGn");

		request.setAttribute("postNo", postNo);
		request.setAttribute("boardno", boardNo);
		request.setAttribute("postGn", postGn);

		request.getRequestDispatcher("/post/postForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
