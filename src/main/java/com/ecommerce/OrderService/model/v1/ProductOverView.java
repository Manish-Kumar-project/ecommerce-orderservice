package com.ecommerce.OrderService.model.v1;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductOverView {
    private String productName;
    private Double productPrice;
    private Long productUniqueId;
    private String productBrandName;
}
