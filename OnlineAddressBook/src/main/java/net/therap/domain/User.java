package net.therap.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12

 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "BJ_OAB_USER")
public class User {

    private long userID;
    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
    @Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String fullName;
    @Email(message = "email should follow the format email@domain.com")
    @Size(min = 10, max = 50, message = "within 10 to 50 characters")
    private String email;
    @Pattern(regexp = "[^\\s]*", message = "space is not allowed")
    @Size(min = 8, max = 30, message = "within 8 to 30 characters")
    private String password;
    @Pattern(regexp = "[^\\s]*", message = "space is not allowed")
    @Size(min = 8, max = 30, message = "within 8 to 30 characters")
    private String confirmPassword;
    private long version;
    private List<AddressCard> addressCardList = new ArrayList<AddressCard>();



    @Id
    @SequenceGenerator(name = "BIJU_OAB_SEQ_USER", sequenceName = "BIJU_OAB_SEQ_USER")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BIJU_OAB_SEQ_USER")
    @Column(name = "USER_ID")
    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    @Column(name = "FULL_NAME")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
    public List<AddressCard> getAddressCardList() {
        return addressCardList;
    }

    public void setAddressCardList(List<AddressCard> addressCardList) {
        this.addressCardList = addressCardList;
    }

    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
