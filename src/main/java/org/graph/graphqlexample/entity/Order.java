package org.graph.graphqlexample.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer totalPrice;
    private String address;
    @ManyToOne
    private User user;
}
