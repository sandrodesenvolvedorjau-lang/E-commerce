package br.kodemaster.dscommerce.entities;

import br.kodemaster.dscommerce.enums.EOrderStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private EOrderStatus status;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public void setClient(User client) {
        this.client = client;
    }

    public Order(User client){
        this.client = client;
    }

    public Order(Instant moment, EOrderStatus status, User client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

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

}
