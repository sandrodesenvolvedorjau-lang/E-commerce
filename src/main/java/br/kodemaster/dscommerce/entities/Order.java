package br.kodemaster.dscommerce.entities;

import br.kodemaster.dscommerce.enums.EOrderStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "id.order")
    private final Set<OrderItem> items = new HashSet<>();


    // Constructors
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

    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Product> getProducts(){
        return items.stream().map(OrderItem::getProduct).toList();
    }
}
