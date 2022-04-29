package com.ecommerce.OrderService.model.v1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderModel {

    private Long orderUniqueId;
    private String productName;
    private String productBrand;
    private Double orderTotalPrice;
}
