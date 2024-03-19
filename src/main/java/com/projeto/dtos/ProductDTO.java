package com.projeto.dtos;


import com.projeto.enums.ProductStatus;

public record ProductDTO(
        String name,
        Integer quantity,
        String type,
        String size,
        ProductStatus productStatus
) {
}
