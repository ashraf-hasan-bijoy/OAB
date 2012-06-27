package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }



    public User getUserByEmailAndPass(String email, String password) {
        User user = userDao.getUserByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        else {
            return user;
        }
    }

    public boolean isEmailExists(String email) {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }


    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
