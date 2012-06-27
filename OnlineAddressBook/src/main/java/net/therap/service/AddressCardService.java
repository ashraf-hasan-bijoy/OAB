package net.therap.service;

import net.therap.domain.AddressCard;
import net.therap.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AddressCardService {

    public void saveAddressCard(User user, AddressCard addressCard);

    public AddressCard getAddressCardById(long id);

    public void updateAddressCard(User user,AddressCard addressCard);

    public List<AddressCard> getAddressCardsByPattern(String pattern);

    public boolean deleteAddressCardById(long id,User user);

    public byte[] getImageData(long id) throws Exception;

    public String getCardExportData(long id);

    public void saveAddressCardByImportedFile(User user, MultipartFile multipartFile);
}
