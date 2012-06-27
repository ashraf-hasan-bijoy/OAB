package net.therap.service;

import net.therap.dao.AddressCardDao;
import net.therap.domain.AddressCard;
import net.therap.domain.Image;
import net.therap.domain.User;
import net.therap.exception.ApplicationException;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddressCardServiceImpl implements AddressCardService {
    private AddressCardDao addressCardDao;
    private static final Logger log = LoggerFactory.getLogger(AddressCardServiceImpl.class);

    public String getCardExportData(long id) {
        AddressCard addressCard = addressCardDao.getAddressCardById(id);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BEGIN:VCARD\n");
        stringBuffer.append("VERSION:4.0\n");
        stringBuffer.append("N:" + addressCard.getName() + ";;;\n");
        stringBuffer.append("FN:" + addressCard.getFullName() + "\n");
        stringBuffer.append("ORG:" + addressCard.getOrganization() + "\n");
        stringBuffer.append("TITLE:" + addressCard.getTitle() + "\n");
        stringBuffer.append("PHOTO:" + addressCard.getPhotoLink() + addressCard.getAddressCardId() +"\n");
        stringBuffer.append("TEL;TYPE=\"work,voice\";VALUE=uri:tel:" + addressCard.getTel_office() + "\n");
        stringBuffer.append("TEL;TYPE=\"home,voice\";VALUE=uri:tel:" + addressCard.getTel_home() + "\n");
        stringBuffer.append("ADR;TYPE=work;LABEL=\"" + addressCard.getAddress() + "\"\n");
        stringBuffer.append("EMAIL:" + addressCard.getEmail() + "\n");
        String formattedDate = addressCard.getLastUpdate().toString().replace("-","").replace(" ","T").replace(":","").replace(".","");
        stringBuffer.append("REV:" + formattedDate + "Z\n");
        stringBuffer.append("END:VCARD\n");
        return stringBuffer.toString();
    }

    public AddressCardDao getAddressCardDao() {
        return addressCardDao;
    }

    public boolean deleteAddressCardById(long id, User user) {

        int result = addressCardDao.deleteAddressCardById(id, user);

        if (result == 0) {
            return false;
        } else {
            return true;
        }

    }

    public List<AddressCard> getAddressCardsByPattern(String pattern , User user) {
        return addressCardDao.getAddressCardsByPattern(pattern,user);
    }

    public void saveAddressCardByImportedFile(User user , MultipartFile multipartFile) {
        AddressCard addressCard = new AddressCard();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(multipartFile.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            reader.readLine();reader.readLine();
            String dataField = reader.readLine();
            dataField = dataField.substring(dataField.indexOf(":")+1, dataField.indexOf(";;;"));

            addressCard.setName(dataField);

            dataField = reader.readLine();
            dataField = dataField.substring(dataField.indexOf(":")+1);

            addressCard.setFullName(dataField);

            dataField = reader.readLine();
            dataField =  dataField.substring(dataField.indexOf(":")+1);

            addressCard.setOrganization(dataField);

            dataField = reader.readLine();
            dataField =  dataField.substring(dataField.indexOf(":")+1);

            addressCard.setTitle(dataField);

            dataField = reader.readLine();
            dataField =  dataField.substring(dataField.indexOf(":")+1);

            addressCard.setPhotoLink(dataField);

            dataField = reader.readLine();
            dataField =  dataField.substring(dataField.indexOf("tel:")+4);

            addressCard.setTel_office(dataField);

            dataField = reader.readLine();
            dataField =  dataField.substring(dataField.indexOf("tel:")+4);

            addressCard.setTel_home(dataField);

            dataField = reader.readLine();
            dataField =  dataField.substring(dataField.indexOf("LABEL=\"")+7).replace("\"","");

            addressCard.setAddress(dataField);


            dataField = reader.readLine();
            dataField =  dataField.substring(dataField.indexOf(":")+1);

            addressCard.setEmail(dataField);

            dataField = reader.readLine();
            dataField =  dataField.substring(dataField.indexOf(":")+1);

            addressCard.setLastUpdate(new Date());


            addressCard.setUser(user);
            addressCardDao.saveAddressCard(addressCard);
        } catch (Exception exception) {
            new ApplicationException("You are trying to access Illegal resource...");
        }
    }

    public void updateAddressCard(User user, AddressCard addressCard) {
        addressCardDao.updateAddressCard(addressCard);
    }

    public AddressCard getAddressCardById(long id) {
        return addressCardDao.getAddressCardById(id);
    }

    public void setAddressCardDao(AddressCardDao addressCardDao) {
        this.addressCardDao = addressCardDao;
    }

    public void saveAddressCard(User user, AddressCard addressCard) {
        Image image = new Image();
        addressCard.setUser(user);
        addressCard.setLastUpdate(new Date());
        addressCard.setPhotoLink("/OnlineAddressBook/image/cardimage.htm?cardid=");
        try {
            image.setImageData(Hibernate.createBlob(addressCard.getImageFile().getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        addressCard.setImage(image);
        image.setAddressCard(addressCard);
        addressCardDao.saveAddressCard(addressCard);
    }

    public byte[] getImageData(long id) throws Exception {

        Blob imageData = addressCardDao.getImageData(id);
        if (imageData == null) {
            throw new Exception();
        }
        byte[] bytes = new byte[(int) imageData.length()];
        imageData.getBinaryStream().read(bytes);
        imageData.getBinaryStream().close();
        return bytes;
    }
}
