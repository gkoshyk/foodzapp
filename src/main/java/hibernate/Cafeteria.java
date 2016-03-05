package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by george on 11/29/2014.
 */
@Entity
public class Cafeteria {
    private int cafeteriaId;
    private String cafeteriaName;
    private String password;

    @Id
    @Column(name = "CafeteriaID")
    public int getCafeteriaId() {
        return cafeteriaId;
    }

    public void setCafeteriaId(int cafeteriaId) {
        this.cafeteriaId = cafeteriaId;
    }

    @Basic
    @Column(name = "CafeteriaName")
    public String getCafeteriaName() {
        return cafeteriaName;
    }

    public void setCafeteriaName(String cafeteriaName) {
        this.cafeteriaName = cafeteriaName;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cafeteria cafeteria = (Cafeteria) o;

        if (cafeteriaId != cafeteria.cafeteriaId) return false;
        if (cafeteriaName != null ? !cafeteriaName.equals(cafeteria.cafeteriaName) : cafeteria.cafeteriaName != null)
            return false;
        if (password != null ? !password.equals(cafeteria.password) : cafeteria.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cafeteriaId;
        result = 31 * result + (cafeteriaName != null ? cafeteriaName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
