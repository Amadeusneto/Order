package br.com.amadeus.order.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_code", nullable = false, updatable = true, insertable = true)
    private Product product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_code", nullable = false, updatable = true, insertable = true)
    private Order order;
}
