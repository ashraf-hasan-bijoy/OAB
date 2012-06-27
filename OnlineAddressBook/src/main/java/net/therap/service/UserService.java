package net.therap.service;

import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public void saveUser(User user);

    public User getUserByEmailAndPass(String email, String password);

    public boolean isEmailExists(String email);

    public User getUserById(long id);
}
