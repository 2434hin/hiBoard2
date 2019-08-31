package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

@WebServlet("/boardPost")
public class BoardPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService;
	private IBoardService boardService;

	@Override
	public void init() throws ServletException {
		postService = new PostService();
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageStr = request.getParameter("page");
        String pagesizeStr = request.getParameter("pagesize");

        int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
        int pagesize = pagesizeStr == null ? 10 : Integer.parseInt(pagesizeStr);

        request.setAttribute("page", page);
        request.setAttribute("pagesize", pagesize);

        int boardNo = Integer.parseInt(request.getParameter("boardno"));

        Map<String, Object> paramter = new HashMap<String, Object>();
        paramter.put("page", page);
        paramter.put("pagesize", pagesize);
        paramter.put("boardNo", boardNo);


        List<Post> postList = postService.getPostList(paramter);
        int paginationSize = (int)Math.ceil((double)postList.size() / pagesize);

		request.setAttribute("postList", postList);
		request.setAttribute("paginationSize", paginationSize);

		Board board = boardService.getBoard(boardNo);
		request.setAttribute("board", board);

		request.getRequestDispatcher("/post/postList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
