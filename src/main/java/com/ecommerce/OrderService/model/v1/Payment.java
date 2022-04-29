package com.ecommerce.OrderService.model.v1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Payment {

    private Long cardNumber;
    private Integer cardCvv;
    private String cardOwnerName;
    private Long cardExpiryDate;
    private String cardBrand;

}
