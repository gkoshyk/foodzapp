package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by george on 11/29/2014.
 */
@Entity
public class Deliveryguy {
    private int deliveryGuyId;
    private String email;
    private String password;
    private String deliveryGuyName;
    private String phoneNumber;
    private String address;

    @Id
    @Column(name = "DeliveryGuyID")
    public int getDeliveryGuyId() {
        return deliveryGuyId;
    }

    public void setDeliveryGuyId(int deliveryGuyId) {
        this.deliveryGuyId = deliveryGuyId;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "DeliveryGuyName")
    public String getDeliveryGuyName() {
        return deliveryGuyName;
    }

    public void setDeliveryGuyName(String deliveryGuyName) {
        this.deliveryGuyName = deliveryGuyName;
    }

    @Basic
    @Column(name = "PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deliveryguy that = (Deliveryguy) o;

        if (deliveryGuyId != that.deliveryGuyId) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (deliveryGuyName != null ? !deliveryGuyName.equals(that.deliveryGuyName) : that.deliveryGuyName != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deliveryGuyId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (deliveryGuyName != null ? deliveryGuyName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
