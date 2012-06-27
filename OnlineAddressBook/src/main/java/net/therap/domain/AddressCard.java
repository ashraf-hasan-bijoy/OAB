package net.therap.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "BJ_OAB_ADDRESS")
public class AddressCard {

    private long addressCardId;
    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
    @Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String name;
    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
    @Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String fullName;
    @Size(min = 5, max = 300, message = "within 5 to 100 characters")
    private String organization;
    @Size(min = 5, max = 300, message = "within 5 to 100 characters")
    private String title;
    @Pattern(regexp = "\\([0-9]{3}\\)\\s[0-9]{3}\\s[0-9]{3}",message = "should in format (xxx) xxx xxx")
    private String tel_home;
    @Pattern(regexp = "\\([0-9]{3}\\)\\s[0-9]{3}\\s[0-9]{3}",message = "should in format (xxx) xxx xxx")
    private String tel_office;
    @Size(min = 20, max = 300, message = "within 20 to 100 characters")
    private String address;
    @Email(message = "email should follow the format email@domain.com")
    @Size(min = 10, max = 50, message = "within 10 to 50 characters")
    private String email;
    private Date lastUpdate;
    private String photoLink ;
    private User user;
    private MultipartFile imageFile;
    private Image image;
    long version;



    @Id
    @SequenceGenerator(name = "BIJU_OAB_SEQ_ADDRESS", sequenceName = "BIJU_OAB_SEQ_ADDRESS")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BIJU_OAB_SEQ_ADDRESS")
    @Column(name = "ADDRESS_CARD_ID")
    public long getAddressCardId() {
        return addressCardId;
    }

    public void setAddressCardId(long addressCardId) {
        this.addressCardId = addressCardId;
    }
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "FULL_NAME")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "ORGANIZATION")
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "TEL_HOME")
    public String getTel_home() {
        return tel_home;
    }

    public void setTel_home(String tel_home) {
        this.tel_home = tel_home;
    }
    @Column(name = "TEL_OFFICE")
    public String getTel_office() {
        return tel_office;
    }

    public void setTel_office(String tel_office) {
        this.tel_office = tel_office;
    }
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Transient
    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "addressCard")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Column(name = "LAST_UPDATE")
    public Date getLastUpdate() {
           return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
           this.lastUpdate = lastUpdate;
    }

    @Column(name = "PHOTO_LINK")
    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }


}
