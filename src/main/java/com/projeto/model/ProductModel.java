package com.projeto.model;

import com.projeto.dtos.ProductDTO;
import com.projeto.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private Integer quantity;

    @Column
    private String size;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    public ProductModel(ProductDTO data){
        this.name = data.name();
        this.quantity = data.quantity();
        this.type = data.type();
        this.size = data.size();
        this.productStatus = ProductStatus.ACTIVE;
    }

}
