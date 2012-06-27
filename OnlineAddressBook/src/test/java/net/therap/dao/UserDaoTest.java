package net.therap.dao;

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
 * Time: 9:22 PM
 * To change this template use File | Settings | File Templates.
 */
@DataSet
@SpringApplicationContext(value = {"classpath:test-applicationContext.xml"})
public class UserDaoTest extends UnitilsTestNG{

    @SpringBean("userDao")
    UserDao userDao;


    @Test
    public void testMappingToDatabase() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }

    @Test
    public void getUserByEmailTest(){
       User user = userDao.getUserByEmail("ashraf@yahoo.com");
       Assert.assertEquals(1L,user.getUserID());
    }

    @Test
    @ExpectedDataSet("UserDaoTest-expected-dataset.xml")
    public void saveUserTest(){
        User user = new User();
        user.setUserID(3L);
        user.setEmail("shaila@yahoo.com");
        user.setPassword("12345");
        user.setFullName("shaila jaman");
        user.setVersion(1L);
        userDao.saveUser(user);
    }
}
