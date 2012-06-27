package net.therap.controller;
import junitx.framework.Assert;
import net.therap.domain.User;
import net.therap.service.UserServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;
import org.unitils.mock.core.MockObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 6/26/12
 * Time: 9:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginControllerTest extends UnitilsTestNG {
    @TestedObject
    LoginController loginController;
    Mock<UserServiceImpl> userServiceMock = new MockObject<UserServiceImpl>(UserServiceImpl.class,this);

    @BeforeClass
    void setUp(){
        loginController = new LoginController();
        loginController.setUserService(userServiceMock.getMock());
    }
    @Test
    public void loginActionTest1(){
        Mock<User> userMock = new MockObject<User>(User.class,this);
        Mock<HttpSession> httpSessionMock = new MockObject<HttpSession>(HttpSession.class,this);
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        Mock<HttpServletResponse> httpServletResponseMock = new MockObject<HttpServletResponse>(HttpServletResponse.class,this);
        userServiceMock.returns(userMock).getUserByEmailAndPass("a@yahoo.com","12345");
        httpServletRequestMock.returns("a@yahoo.com").getParameter("email");
        httpServletRequestMock.returns("12345").getParameter("password");
        httpServletRequestMock.returns("www.abc.com").getHeader("Referer");
        httpServletRequestMock.returns(httpSessionMock).getSession();
        String result = loginController.loginAction(httpServletRequestMock.getMock(),httpServletResponseMock.getMock());
        Assert.assertEquals(result,"redirect:/app/home.htm");
    }
    @Test
    public void loginActionTest2(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        Mock<HttpServletResponse> httpServletResponseMock = new MockObject<HttpServletResponse>(HttpServletResponse.class,this);
        userServiceMock.returns(null).getUserByEmailAndPass("a@yahoo.com","12345");
        httpServletRequestMock.returns("a@yahoo.com").getParameter("email");
        httpServletRequestMock.returns("12345").getParameter("password");
        httpServletRequestMock.returns("www.abc.com").getHeader("Referer");
        String result = loginController.loginAction(httpServletRequestMock.getMock(),httpServletResponseMock.getMock());
        Assert.assertEquals(result,"redirect:www.abc.com?errorcode=1");
    }
}
