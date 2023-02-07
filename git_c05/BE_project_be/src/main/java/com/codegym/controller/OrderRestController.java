package com.codegym.controller;

import com.codegym.dto.cart.IOrderDetailDto;
import com.codegym.dto.cart.ITotalDto;
import com.codegym.service.order.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class OrderRestController {
    @Autowired
    private IOrderDetailService iOrderDetailService;

    @GetMapping("/list")
    public ResponseEntity<List<IOrderDetailDto>> getCartList() {
        List<IOrderDetailDto> cartDtos = iOrderDetailService.getCartList();
        if (cartDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cartDtos, HttpStatus.OK);
    }

    @GetMapping("/total-bill")
    public ResponseEntity<ITotalDto> getTotalBill() {
        ITotalDto totalBill = iOrderDetailService.getTotalBill();
        if (totalBill == null) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(totalBill, HttpStatus.OK);
    }

    @PostMapping("/cart-update")
    public ResponseEntity<?> updateCart(@RequestParam Integer id) {
        IOrderDetailDto iOrderDetailDto = iOrderDetailService.findById(id);
        if (iOrderDetailDto == null) {
            iOrderDetailService.insertToCart(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        iOrderDetailService.updateCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/quantity-update")
    public ResponseEntity<?> updateQty(@RequestParam Integer id,
                                       @RequestParam Integer quantity) {
        iOrderDetailService.updateQty(id, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-product")
    public ResponseEntity<?> deleteAlcohol(@RequestParam Integer id) {
        iOrderDetailService.deleteAlcohol(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
