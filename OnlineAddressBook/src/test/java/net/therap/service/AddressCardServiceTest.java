package net.therap.service;
import net.therap.dao.AddressCardDao;
import net.therap.dao.AddressCardDaoImpl;
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

public class AddressCardServiceTest extends UnitilsTestNG {
    @TestedObject
    AddressCardServiceImpl addressCardService;
    Mock<AddressCardDaoImpl> addressCardDaoMock = new MockObject<AddressCardDaoImpl>(AddressCardDaoImpl.class,this);

    @BeforeClass
    public void setup(){
       addressCardService = new AddressCardServiceImpl();
       addressCardService.setAddressCardDao(addressCardDaoMock.getMock());
    }

    @Test
    public void deleteAddressCardByIdTest1(){
        Mock<User> userMock = new MockObject<User>(User.class,this);
        addressCardDaoMock.returns(1).deleteAddressCardById(1L,userMock.getMock());
        boolean result = addressCardService.deleteAddressCardById(1L,userMock.getMock());
        Assert.assertEquals(true,result);
    }

    @Test
    public void deleteAddressCardByIdTest2(){
        Mock<User> userMock = new MockObject<User>(User.class,this);
        addressCardDaoMock.returns(0).deleteAddressCardById(1L,userMock.getMock());
        boolean result = addressCardService.deleteAddressCardById(1L,userMock.getMock());
        Assert.assertEquals(false,result);
    }

    @Test
    public void getPageCountByUserTest(){
        Mock<User> userMock = new MockObject<User>(User.class,this);
        addressCardDaoMock.returns(10L).getPageCountByUser(userMock.getMock());
        long result = addressCardService.getPageCountByUser(userMock.getMock());
        Assert.assertEquals(4L,result);
    }

}
