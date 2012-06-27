package net.therap.domain;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/13/12
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "BJ_OAB_IMAGE")
public class Image {

    private long imageId;
    private Blob imageData;
    private long version;
    private AddressCard addressCard;

    @Lob
    @Column(name = "IMAGE_DATA")
    public Blob getImageData() {
        return imageData;
    }

    public void setImageData(Blob imageData) {
        this.imageData = imageData;
    }

    @Id
    @SequenceGenerator(name = "BIJU_OAB_SEQ_IMAGE", sequenceName = "BIJU_OAB_SEQ_IMAGE")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BIJU_OAB_SEQ_IMAGE")
    @Column(name = "IMAGE_ID")
    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    @OneToOne
    @JoinColumn(name = "ADDRESS_CARD_ID")
    public AddressCard getAddressCard() {
        return addressCard;
    }

    public void setAddressCard(AddressCard addressCard) {
        this.addressCard = addressCard;
    }

    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

}
