package com.store.retailstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private final String productName ;
    private final double productUnitPrice ;
    private final ProductType productType;

    public String getProductName() {
        return productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public double getProductUnitPrice() {
        return productUnitPrice;
    }

    public double getTotalProductPrice(int quantity) {
        return productUnitPrice * quantity;
    }
}
