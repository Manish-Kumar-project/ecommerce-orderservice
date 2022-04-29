package com.ecommerce.OrderService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_unique_id")
    private String orderUniqueId;

    @Column(name = "member_id")
    private Long memberId;


    @Column(name = "order_total_price")
    private Double orderTotalPrice;


    @Column(name = "product_unique_id", nullable = false)
    private Long productUniqueid;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "card_number", nullable = false)
    private Long CardNumber;

    @Column(name = "card_expiry", length = 500)
    private Integer cardExpiry;

    @Column(name = "card_cvv", nullable = false)
    private String cardCvv;

    @Column(name = "cardBrand", nullable = false)
    private String cardBrand;

    @Column(name = "card_owner_name", nullable = false)
    private String cardOwnerName;

    @Column(name = "product_brand", nullable = false)
    private String productBrand;

    @Column(name = "product_name")
    private Date productName;

    @Column(name = "order_created_by")
    private String orderCreatedBy;

    @Column(name = "order_upadated_date")
    private Date orderUpdatedDate;

    @Column(name = "order_updated_by")
    private String orderUpdatedBy;

}
