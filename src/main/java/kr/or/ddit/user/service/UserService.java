package kr.or.ddit.user.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.util.MybatisUtil;

public class UserService implements IUserService {

	private IUserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	/**
	 *
	 * Method : getUser
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 상세조회
	 */
	@Override
	public User getUser(String userId) {

		SqlSession sqlSession = MybatisUtil.getSession();
		User user = userDao.getUser(sqlSession, userId);
		sqlSession.close();

		return user;
	}

}
