package net.therap.dao;

import net.therap.domain.AddressCard;
import net.therap.domain.Image;
import net.therap.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 1:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddressCardDaoImpl extends HibernateDaoSupport implements AddressCardDao {
    public void saveAddressCard(AddressCard addressCard) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.saveOrUpdate(addressCard);
        session.flush();
    }

    public void updateAddressCard(AddressCard addressCard) {
        addressCard.setLastUpdate(new Date());
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.update(addressCard);
        session.flush();
    }

    public int deleteAddressCardById(long id, User user) {

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        AddressCard addressCard = (AddressCard)session.get(AddressCard.class,id);
        Image image = addressCard.getImage();
        Query query;
        if(image != null){
           query = session.createQuery("delete from Image as image where image.addressCard = :addressCard and image.imageId = :imageId");
           query.setParameter("addressCard",addressCard);
           query.setParameter("imageId",image.getImageId());
           query.executeUpdate();
        }
        query = session.createQuery("delete from AddressCard as addressCard where addressCard.user = :user and addressCard.addressCardId = :id");
        query.setParameter("user",user);
        query.setParameter("id",id);
        session.flush();
        return query.executeUpdate();

    }

    public List<AddressCard> getAddressCardsByPattern(String pattern , User user) {
        return getHibernateTemplate().find("select addressCard from AddressCard as addressCard where addressCard.user = ? and addressCard.fullName like ?",new Object[]{user,"%"+pattern.toLowerCase()+"%"});
    }

    public AddressCard getAddressCardById(long id) {
        return getHibernateTemplate().get(AddressCard.class,id);
    }

    public Blob getImageData(long id) {
        List<Blob> blobList = getHibernateTemplate().find("select image.imageData from Image as image where image.addressCard.addressCardId = ?", new Object[]{id});
        if (blobList.size() != 0) {
            return blobList.get(0);
        } else {
            return null;
        }
    }
}
