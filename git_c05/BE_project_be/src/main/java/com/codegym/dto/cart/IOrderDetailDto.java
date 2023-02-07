package com.codegym.dto.cart;

public interface IOrderDetailDto {
    Integer getId();
    Integer getQuantity();
    double getPrice();
    double getSumPerOne();
    String getImage();
    String getName();
}
