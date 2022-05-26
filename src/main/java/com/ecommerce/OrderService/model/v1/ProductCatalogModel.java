package com.ecommerce.OrderService.model.v1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductCatalogModel {

    private String productCatalogName;
    private String productCatalogType;
    private Long productCatalogUniqueId;
    private Integer productCatalogQuantity;
    private Integer productQuantity;
    private String productBrand;

}
