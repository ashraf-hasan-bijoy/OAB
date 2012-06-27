package net.therap.controller;
import net.therap.domain.*;
import net.therap.service.AddressCardService;
import net.therap.service.AddressCardServiceImpl;
import net.therap.service.UserService;
import net.therap.service.UserServiceImpl;
import org.testng.Assert;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;
import org.testng.annotations.*;
import org.unitils.mock.Mock;
import org.unitils.mock.core.MockObject;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 6/26/12
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddressControllerTest extends UnitilsTestNG{
    @TestedObject
    AddressController addressController;
    Mock<UserServiceImpl> userService = new MockObject<UserServiceImpl>(UserServiceImpl.class,this);
    Mock<AddressCardServiceImpl> addressCardService = new MockObject<AddressCardServiceImpl>(AddressCardServiceImpl.class,this);

    @BeforeClass
    public void setUp(){
        addressController = new AddressController();
        addressController.setUserService(userService.getMock());
        addressController.setAddressCardService(addressCardService.getMock());
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void deleteAddressCardActionTest1(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        httpServletRequestMock.returns(null).getParameter("cardid");
        addressController.deleteAddressCardAction(httpServletRequestMock.getMock(),new HashMap<String, Object>());
    }

    @Test
    public void deleteAddressCardActionTest2(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        Mock<User> userMock = new MockObject<User>(User.class,this);
        httpServletRequestMock.returns(userMock).getSession().getAttribute("user");
        httpServletRequestMock.returns("2").getParameter("cardid");
        addressCardService.returns(true).deleteAddressCardById(2L,userMock.getMock());
        String result = addressController.deleteAddressCardAction(httpServletRequestMock.getMock(),new HashMap<String, Object>());
        Assert.assertEquals("redirect:/app/address/cardlist.htm",result);
    }

    @Test
    public void searchAddressCardPostActionTest1(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        httpServletRequestMock.returns(null).getParameter("cardid");
        String result = addressController.searchAddressCardPostAction(httpServletRequestMock.getMock(),new HashMap<String, Object>());
        Assert.assertEquals("redirect:/app/address/search.htm?error=1",result);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void searchAddressCardPostActionTest2(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        httpServletRequestMock.returns(2).getParameter("cardid");
        String result = addressController.viewAddressCardAction(httpServletRequestMock.getMock(),new HashMap<String, Object>());
        Assert.assertEquals("cardsearch",result);
    }

    @Test
    public void viewAddressCardActionTest1(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        httpServletRequestMock.returns("2").getParameter("cardid");
        String result = addressController.viewAddressCardAction(httpServletRequestMock.getMock(),new HashMap<String, Object>());
        Assert.assertEquals("viewaddresscard",result);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void viewAddressCardActionTest2(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        httpServletRequestMock.returns(2).getParameter("cardid");
        addressController.viewAddressCardAction(httpServletRequestMock.getMock(),new HashMap<String, Object>());
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void editAddressCardGetActionTest1(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        httpServletRequestMock.returns(null).getParameter("cardid");
        addressController.editAddressCardGetAction(httpServletRequestMock.getMock(),new HashMap<String, Object>());
    }

    @Test
    public void editAddressCardGetActionTest2(){
        Mock<HttpServletRequest> httpServletRequestMock = new MockObject<HttpServletRequest>(HttpServletRequest.class,this);
        httpServletRequestMock.returns("2").getParameter("cardid");
        String result = addressController.editAddressCardGetAction(httpServletRequestMock.getMock(),new HashMap<String, Object>());
        Assert.assertEquals("editaddresscard",result);
    }

}
