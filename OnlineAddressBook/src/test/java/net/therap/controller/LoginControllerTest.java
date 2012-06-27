package net.therap.controller;
import junitx.framework.Assert;
import net.therap.service.UserServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;
import org.unitils.mock.core.MockObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        loginController.setUserService(userServiceMock.getMock());
    }
    @Test
    void loginActionTest1(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        Mock<HttpServletResponse> httpServletResponseMock = new MockObject<HttpServletResponse>(HttpServletResponse.class,this);
        userServiceMock.returns(null).getUserByEmailAndPass("a@yahoo.com","12345");
        httpServletRequestMock.returns("a@yahoo.com").getParameter("email");
        httpServletRequestMock.returns("12345").getParameter("password");
        httpServletRequestMock.returns("www.abc.com").getHeader("Referer");
        httpServletRequestMock.returns(false).getHeader("Referer").contains("errorcode");
        String result = loginController.loginAction(httpServletRequestMock.getMock(),httpServletResponseMock.getMock());
        Assert.assertEquals(result,"www.abc.com?errorcode=1");
    }
    @Test
    void loginActionTest2(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        Mock<HttpServletResponse> httpServletResponseMock = new MockObject<HttpServletResponse>(HttpServletResponse.class,this);
        userServiceMock.returns(null).getUserByEmailAndPass("a@yahoo.com","12345");
        httpServletRequestMock.returns("a@yahoo.com").getParameter("email");
        httpServletRequestMock.returns("12345").getParameter("password");
        httpServletRequestMock.returns("www.abc.com").getHeader("Referer");
        httpServletRequestMock.returns(true).getHeader("Referer").contains("errorcode");
        String result = loginController.loginAction(httpServletRequestMock.getMock(),httpServletResponseMock.getMock());
        Assert.assertEquals(result,"www.abc.com");
    }
}
