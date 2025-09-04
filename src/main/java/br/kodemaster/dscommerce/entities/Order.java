package br.kodemaster.dscommerce.entities;

import br.kodemaster.dscommerce.enums.EOrderStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_orders")
public class Order extends BaseEntity {

    // Attributes
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private EOrderStatus status;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "client_uuid", referencedColumnName = "uuid")
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;


    public Order(){}

    public Order(Instant moment, EOrderStatus status, User client, Payment payment) {
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    // Getters and Setters
    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public EOrderStatus getStatus() {
        return status;
    }

    public void setStatus(EOrderStatus status) {
        this.status = status;
    }

    public User getClient(){
        return client;
    }

    public Payment getPayment() {
        return payment;
    }

}
