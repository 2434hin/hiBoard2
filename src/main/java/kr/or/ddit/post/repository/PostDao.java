package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.model.PostFile;

public class PostDao implements IPostDao {

	/**
	 *
	 * Method : getPostList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param paramter
	 * @return
	 * Method 설명 : 게시판 번호에 맞는 게시글 출력
	 */
	@Override
	public List<Post> getPostList(SqlSession sqlSession, Map<String, Object> paramter) {
		return sqlSession.selectList("post.getPostList", paramter);
	}

	/**
	 *
	 * Method : getPost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 상세 정보 조회
	 */
	@Override
	public Post getPost(SqlSession sqlSession, int postNo) {
		return sqlSession.selectOne("post.getPost", postNo);
	}

	/**
	 *
	 * Method : insertPost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param post
	 * @return
	 * Method 설명 : 새글 작성
	 */
	@Override
	public int insertPost(SqlSession sqlSession, Post post) {
		return sqlSession.insert("post.insertPost", post);
	}

	/**
	 *
	 * Method : getPostNo
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 신규 게시글의 게시글 번호 조회
	 */
	@Override
	public int getPostNo(SqlSession sqlSession) {
		return sqlSession.selectOne("post.getPostNo");
	}

	/**
	 *
	 * Method : deletePost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 삭제
	 */
	@Override
	public int deletePost(SqlSession sqlSession, int postNo) {
		return sqlSession.update("post.deletePost", postNo);
	}

	/**
	 *
	 * Method : insertPostFile
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param postFile
	 * @return
	 * Method 설명 : 게시글 작성 시 파일 저장
	 */
	@Override
	public int insertPostFile(SqlSession sqlSession, PostFile postFile) {
		return sqlSession.insert("post.insertPostFile", postFile);
	}

	/**
	 *
	 * Method : getPostFileList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 번호에 맞는 파일 조회
	 */
	@Override
	public List<PostFile> getPostFileList(SqlSession sqlSession, int postNo) {
		return sqlSession.selectList("post.getPostFileList", postNo);
	}

	/**
	 *
	 * Method : updatePost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param post
	 * @return
	 * Method 설명 : 게시글 수정
	 */
	@Override
	public int updatePost(SqlSession sqlSession, Post post) {
		return sqlSession.update("post.updatePost", post);
	}

}
