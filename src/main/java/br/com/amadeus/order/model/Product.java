package br.com.amadeus.order.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome deve ser preenchido.")
    private String name;

    @NotEmpty(message = "O valor deve ser preenchido.")
    private Double value;
}
