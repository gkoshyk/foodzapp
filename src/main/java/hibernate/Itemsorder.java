package hibernate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by george on 11/22/2014.
 */
@Entity
public class Itemsorder {
    private int orderId;
    private Float amount;
    private Timestamp dateAndTimeOfOrder;
    private Customer customerByCustomerId;

    @Id
    @Column(name = "OrderID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "Amount")
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "DateAndTimeOfOrder")
    public Timestamp getDateAndTimeOfOrder() {
        return dateAndTimeOfOrder;
    }

    public void setDateAndTimeOfOrder(Timestamp dateAndTimeOfOrder) {
        this.dateAndTimeOfOrder = dateAndTimeOfOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Itemsorder that = (Itemsorder) o;

        if (orderId != that.orderId) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (dateAndTimeOfOrder != null ? !dateAndTimeOfOrder.equals(that.dateAndTimeOfOrder) : that.dateAndTimeOfOrder != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (dateAndTimeOfOrder != null ? dateAndTimeOfOrder.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
