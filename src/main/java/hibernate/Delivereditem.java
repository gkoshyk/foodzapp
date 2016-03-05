package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by george on 11/29/2014.
 */
@Entity
public class Delivereditem {
    private Integer deliveryGuyId;
    private Integer orderId;
    private Integer amountGotForDelivery;
    private String deliveredForCafeteria;

    @Basic
    @Column(name = "DeliveryGuyID")
    public Integer getDeliveryGuyId() {
        return deliveryGuyId;
    }

    public void setDeliveryGuyId(Integer deliveryGuyId) {
        this.deliveryGuyId = deliveryGuyId;
    }

    @Basic
    @Column(name = "OrderID")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "AmountGotForDelivery")
    public Integer getAmountGotForDelivery() {
        return amountGotForDelivery;
    }

    public void setAmountGotForDelivery(Integer amountGotForDelivery) {
        this.amountGotForDelivery = amountGotForDelivery;
    }

    @Basic
    @Column(name = "DeliveredForCafeteria")
    public String getDeliveredForCafeteria() {
        return deliveredForCafeteria;
    }

    public void setDeliveredForCafeteria(String deliveredForCafeteria) {
        this.deliveredForCafeteria = deliveredForCafeteria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivereditem that = (Delivereditem) o;

        if (amountGotForDelivery != null ? !amountGotForDelivery.equals(that.amountGotForDelivery) : that.amountGotForDelivery != null)
            return false;
        if (deliveredForCafeteria != null ? !deliveredForCafeteria.equals(that.deliveredForCafeteria) : that.deliveredForCafeteria != null)
            return false;
        if (deliveryGuyId != null ? !deliveryGuyId.equals(that.deliveryGuyId) : that.deliveryGuyId != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deliveryGuyId != null ? deliveryGuyId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (amountGotForDelivery != null ? amountGotForDelivery.hashCode() : 0);
        result = 31 * result + (deliveredForCafeteria != null ? deliveredForCafeteria.hashCode() : 0);
        return result;
    }
}
