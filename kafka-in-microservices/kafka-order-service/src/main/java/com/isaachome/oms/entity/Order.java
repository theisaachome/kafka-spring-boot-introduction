package com.isaachome.oms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private int orderId;

    @Column
    private String orderNumber;

    @Column
    private String orderLocation;

    @Column
    private LocalDateTime orderDateTime;

    @Column
    private String creditCardNumber;
    @OneToMany(mappedBy = "order",orphanRemoval = true)
    private List<OrderItem> orderItems= new ArrayList<>();
}
