package com.ecommerce.OrderService.commons;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PaymentTransaction {

    private Long memberId;
    private String cardOwnerName;
    private Double transactionAmount;
    private Long transactionId;
    private Long cardNumber;
    private Integer cardExpiry;
    private String cardCvv;
    private String cardBrand;
    private String cardType;
    private String responseMessage;
}
