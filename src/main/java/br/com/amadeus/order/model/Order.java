package br.com.amadeus.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private Long orderCode;

    @OneToMany(mappedBy = "order", cascade = CascadeType.MERGE)
    private List<OrderProduct> orderProduct;

    @NotEmpty(message = "O numero controle deve ser preenchido.")
    private Long controlNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @NotEmpty(message = "O nome deve ser preenchido.")
    private String name;

    @NotEmpty(message = "O valor deve ser preenchido.")
    private Double valor;

    private Integer quantity;

    @NotEmpty(message = "O codigo cliente deve ser preenchido.")
    private Long clientCode;

    private Double orderTotal;
}
