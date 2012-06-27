package net.therap.service;
import net.therap.dao.UserDaoImpl;
import net.therap.domain.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;
import org.unitils.mock.core.MockObject;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 6/26/12
 * Time: 9:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceTest extends UnitilsTestNG {
    @TestedObject
    UserServiceImpl userService;
    Mock<UserDaoImpl> userDaoMock = new MockObject<UserDaoImpl>(UserDaoImpl.class,this);

    @BeforeClass
    public void setup(){
        userService = new UserServiceImpl();
        userService.setUserDao(userDaoMock.getMock());

    }

    @Test
    public void getUserByEmailAndPassTest1(){
        userDaoMock.returns(null).getUserByEmail("a@yahoo.com");
        Object object = userService.getUserByEmailAndPass("a@yahoo.com","12345");
        Assert.assertEquals(object,null);
    }

    @Test
    public void getUserByEmailAndPassTest2(){
        Mock<User> userMock = new MockObject<User>(User.class,this);
        userMock.returns("12345").getPassword();
        userMock.returns("a@yahoo.com").getEmail();
        userDaoMock.returns(userMock).getUserByEmail("a@yahoo.com");
        User user = userService.getUserByEmailAndPass("a@yahoo.com","12345");
        Assert.assertEquals(user.getEmail(),"a@yahoo.com");
        Assert.assertEquals(user.getPassword(),"12345");
    }
}
