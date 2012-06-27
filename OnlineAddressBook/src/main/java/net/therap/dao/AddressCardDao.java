package net.therap.dao;

import net.therap.domain.AddressCard;
import net.therap.domain.User;

import java.sql.Blob;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 1:32 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AddressCardDao {

    public void saveAddressCard(AddressCard addressCard);

    public AddressCard getAddressCardById(long id);

    public void updateAddressCard(AddressCard addressCard);

    public List<AddressCard> getAddressCardsByPattern(String pattern);

    public int deleteAddressCardById(long id,User user);

     public Blob getImageData(long id);

}
