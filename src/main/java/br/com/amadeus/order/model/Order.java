package br.com.amadeus.order.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    @NotEmpty(message = "O numero controle deve ser preenchido.")
    @Column(unique = true)
    private Long controlNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

    private Integer quantity = 1;

    @NotEmpty(message = "O codigo cliente deve ser preenchido.")
    private Long clientCode;

    private Double orderTotal;
}
