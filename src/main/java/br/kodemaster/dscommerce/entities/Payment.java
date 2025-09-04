package br.kodemaster.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_payments")
public class Payment  extends BaseEntity{

    // Attributes
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    // Relationships
    @OneToOne
    @JoinColumn(name = "order_uuid", referencedColumnName = "uuid")
    private Order order;

    public Payment() {}

    public Payment(Order order) {
        this.order = order;
    }

    // Getters and Setters
    public Payment(Instant moment, Order order) {
        this.moment = moment;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }
}
