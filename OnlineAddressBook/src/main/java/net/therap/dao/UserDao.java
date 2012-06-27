package net.therap.dao;

import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 11:48 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {

    public void saveUser(User user);

    public User getUserByEmail(String email);

    public User getUserById(long id);

}
