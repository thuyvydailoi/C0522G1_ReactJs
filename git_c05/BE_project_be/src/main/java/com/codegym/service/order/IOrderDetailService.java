package com.codegym.service.order;

import com.codegym.dto.cart.IOrderDetailDto;
import com.codegym.dto.cart.ITotalDto;

import java.util.List;

public interface IOrderDetailService {
    List<IOrderDetailDto> getCartList();

    ITotalDto getTotalBill();

    void updateCart(Integer id);

    void insertToCart(Integer id);

    void updateQty(Integer id, Integer quantity);

    void deleteAlcohol(Integer id);

    IOrderDetailDto findById(Integer id);
}
