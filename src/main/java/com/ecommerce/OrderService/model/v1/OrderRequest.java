package com.ecommerce.OrderService.model.v1;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderRequest {

    private String orderUniqueId;
    private Double orderTotalPrice;
    private Double productUniqueId;
    private Double productPrice;
    private String cardType;
    private Double CardNumber;
    private String cardExpiry;
    private String cardCvv;
    private String cardBrand;
    private Integer cardOwnerName;
    private String productBrand;
    private Date productName;
    private String orderCreatedBy;
    private Date orderUpdatedDate;
    private String orderUpdatedBy;


}
