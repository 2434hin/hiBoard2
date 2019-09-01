package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.model.PostFile;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/updatePost")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class UpdatePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService;

	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 수정 할 게시글 창에 게시글 조회

		int postNo = Integer.parseInt(request.getParameter("postNo"));

		// 게시글 가져오기
		Post post = postService.getPost(postNo);
		// 게시글 파일 가져오기
		List<PostFile> fileList = postService.getPostFileList(postNo);

		request.setAttribute("post", post);
		request.setAttribute("fileList", fileList);

		request.getRequestDispatcher("/post/updatePost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 수정항 게시글 update

		request.setCharacterEncoding("UTF-8");
		int postNo = Integer.parseInt(request.getParameter("postNo"));		// 게시글 번호
		String postTitle = request.getParameter("postTitle");				// 게시글 제목
		String postContent = request.getParameter("postContent");			// 게시글 내용

		Post post = new Post();
		post.setPostno(postNo);
		post.setPosttitle(postTitle);
		post.setPostcontent(postContent);

		int updateCnt = postService.updatePost(post);
		
		String filename = "";
		String path = "";
		Collection<Part> file = request.getParts();
		for(Part p : file) {
			if("file".equals(p.getName())) {
				if(p.getSize() > 0) {
					filename = FileuploadUtil.getFilename(p.getHeader("Content-Disposition"));	// 사용자가 업로드한 파일명
					String realFilename = UUID.randomUUID().toString();
					String ext = FileuploadUtil.getFileExtension(p.getHeader("Content-Disposition"));
					path = FileuploadUtil.getPath() + realFilename + ext;

					p.write(path);

					PostFile postFile = new PostFile(filename, path, postNo);
					
					postService.insertPostFile(postFile);
				}
			}
		}

		// 게시글 수정 성공 시
		if(updateCnt > 0) {
			response.sendRedirect(request.getContextPath() + "/post?postNo=" + postNo);
		}else {
			doGet(request, response);
		}

	}

}
