package br.kodemaster.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK {

    // Attributes
    @ManyToOne
    @JoinColumn(name = "order_uuid")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_uuid")
    private Product product;

    // Constructors
    public OrderItemPK() {}

    // Getters and Setters
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
