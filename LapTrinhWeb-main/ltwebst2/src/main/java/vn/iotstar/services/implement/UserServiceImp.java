package vn.iotstar.services.implement;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.implement.UserDaoImp;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserServiceImp implements IUserService {

	IUserDao userDao = new UserDaoImp(); // Lay toan bo ham trong tang DAO cua user

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);

	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(username, password, email, fullname, null, 1, phone, date));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void updatePassword(String email, String password) {
		// TODO Auto-generated method stub
		userDao.updatePassword(email, password);
		
	}
	
	
}
