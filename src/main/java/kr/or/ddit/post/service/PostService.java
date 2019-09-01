package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.model.PostFile;
import kr.or.ddit.post.repository.IPostDao;
import kr.or.ddit.post.repository.PostDao;
import kr.or.ddit.util.MybatisUtil;

public class PostService implements IPostService {

	private IPostDao postDao;

	public PostService() {
		postDao = new PostDao();
	}

	/**
	 *
	 * Method : getPostList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param paramter
	 * @return
	 * Method 설명 : 게시판 번호에 맞는 게시글 조회
	 */
	@Override
	public List<Post> getPostList(Map<String, Object> paramter) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Post> postList = postDao.getPostList(sqlSession, paramter);
		sqlSession.close();

		return postList;
	}

	/**
	 *
	 * Method : getPost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 상세 정보 조회
	 */
	@Override
	public Post getPost(int postNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Post post = postDao.getPost(sqlSession, postNo);
		sqlSession.close();

		return post;
	}

	/**
	 *
	 * Method : insertPost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param post
	 * @return
	 * Method 설명 : 새글 작성
	 */
	@Override
	public int insertPost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = postDao.insertPost(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	/**
	 *
	 * Method : getPostNo
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 신규 게시글의 게시글 번호 조회
	 */
	@Override
	public int getPostNo() {
		SqlSession sqlSession = MybatisUtil.getSession();
		int postNo = postDao.getPostNo(sqlSession);
		sqlSession.close();
		return postNo;
	}

	/**
	 *
	 * Method : deletePost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 삭제
	 */
	@Override
	public int deletePost(int postNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deletePost = postDao.deletePost(sqlSession, postNo);
		sqlSession.commit();
		sqlSession.close();
		return deletePost;
	}

	/**
	 *
	 * Method : insertPostFile
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postFile
	 * @return
	 * Method 설명 : 게시글 작성 시 파일 저장
	 */
	@Override
	public int insertPostFile(PostFile postFile) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = postDao.insertPostFile(sqlSession, postFile);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	/**
	 *
	 * Method : getPostFileList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 번호에 맞는 파일 조회
	 */
	@Override
	public List<PostFile> getPostFileList(int postNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<PostFile> postFileList = postDao.getPostFileList(sqlSession, postNo);
		sqlSession.close();

		return postFileList;
	}

	/**
	 *
	 * Method : updatePost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param post
	 * @return
	 * Method 설명 : 게시글 수정
	 */
	@Override
	public int updatePost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updatePost = postDao.updatePost(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		return updatePost;
	}

	/**
	 * 
	 * Method : delet1eFile
	 * 작성자 : user
	 * 변경이력 :
	 * @param fileNo
	 * @return
	 * Method 설명 : 파일 삭제
	 */
	@Override
	public int deleteFile(int fileNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteFile = postDao.deleteFile(sqlSession, fileNo);
		sqlSession.commit();
		sqlSession.close();
		return deleteFile;
	}

	/**
	 * 
	 * Method : getPostTotalCnt
	 * 작성자 : user
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시글 거수 조회
	 */
	@Override
	public int getPostTotalCnt() {
		SqlSession sqlSession = MybatisUtil.getSession();
		int postTotalCnt = postDao.getPostTotalCnt(sqlSession);
		sqlSession.close();
		return postTotalCnt;
	}


}
