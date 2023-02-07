package com.codegym.service.order.impl;

import com.codegym.dto.cart.IOrderDetailDto;
import com.codegym.dto.cart.ITotalDto;
import com.codegym.repository.cart.IOrderDetailRepository;
import com.codegym.service.order.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;

    @Override
    public List<IOrderDetailDto> getCartList() {
        return iOrderDetailRepository.getCartList();
    }

    @Override
    public ITotalDto getTotalBill() {
        return iOrderDetailRepository.getTotalBill();
    }

    @Override
    public void updateCart(Integer id) {
        iOrderDetailRepository.updateCart(id);
    }

    @Override
    public void insertToCart(Integer id) {
        iOrderDetailRepository.insertToCart(id);
    }

    @Override
    public void updateQty(Integer id, Integer quantity) {
        iOrderDetailRepository.updateQuantity(id, quantity);
    }

    @Override
    public void deleteAlcohol(Integer id) {
        iOrderDetailRepository.deleteAlcohol(id);
    }

    @Override
    public IOrderDetailDto findById(Integer id) {
        return iOrderDetailRepository.findByIdAlcohol(id);
    }
}
