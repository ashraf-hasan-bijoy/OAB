package net.therap.controller;
import junitx.framework.Assert;
import net.therap.domain.User;
import net.therap.service.UserServiceImpl;
import org.springframework.validation.BindingResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;
import org.unitils.mock.core.MockObject;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 6/26/12
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserRegControllerTest extends UnitilsTestNG {
    @TestedObject
    UserRegController userRegController;
    Mock<UserServiceImpl> userServiceMock = new MockObject<UserServiceImpl>(UserServiceImpl.class,this);

    @BeforeClass
    public void setUp(){
       userRegController = new UserRegController();
       userRegController.setUserService(userServiceMock.getMock());
    }

    @Test
    public void customerRegActionTest(){
        String result = userRegController.customerRegAction(new HashMap<String, Object>());
        Assert.assertEquals(result,"userreg");
    }

    @Test
    public void saveFlatOwnerActionTest1(){
        Mock<User> userMock = new MockObject<User>(User.class,this);
        Mock<BindingResult> bindingResultMock = new MockObject<BindingResult>(BindingResult.class,this);
        bindingResultMock.returns(true).hasErrors();
        userMock.returns("a@yahoo.com").getEmail();
        userMock.returns("12345").getConfirmPassword();
        userMock.returns("12345").getPassword();
        userServiceMock.returns(true).isEmailExists("a@yahoo.com");
        String result = userRegController.saveFlatOwnerAction(userMock.getMock(),bindingResultMock.getMock());
        Assert.assertEquals("userreg",result);
    }

}
