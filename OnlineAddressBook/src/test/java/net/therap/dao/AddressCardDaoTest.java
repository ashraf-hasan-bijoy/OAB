package net.therap.dao;

import net.therap.domain.AddressCard;
import net.therap.domain.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.orm.hibernate.HibernateUnitils;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 6/26/12
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
@DataSet
@SpringApplicationContext(value = {"classpath:test-applicationContext.xml"})
public class AddressCardDaoTest extends UnitilsTestNG {
    @SpringBean("addressCardDao")
    AddressCardDao addressCardDao;

    @Test
    public void testMappingToDatabase() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }

    @Test
    @ExpectedDataSet("AddressCardDaoTest-expected-dataset.xml")
    public void deleteAddressCardById(){
       User user = new User();
       user.setUserID(1L);
       user.setEmail("ashraf@yahoo.com");
       user.setFullName("ashraf hasan");
       user.setVersion(1L);
       user.setPassword("12345");
       addressCardDao.deleteAddressCardById(1L,user);
    }
}


