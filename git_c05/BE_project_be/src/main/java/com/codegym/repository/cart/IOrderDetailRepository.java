package com.codegym.repository.cart;

import com.codegym.dto.cart.IOrderDetailDto;
import com.codegym.dto.cart.ITotalDto;
import com.codegym.model.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Query(value = "select (order_detail.quantity * alcohol.price) as sumPerOne, order_detail.id as id, order_detail.quantity as quantity, " +
            "alcohol.name as name, alcohol.price as price, alcohol.image as image " +
            "from order_detail " +
            "join alcohol on order_detail.alcohol_id = alcohol.id " +
            "where order_detail.is_delete = 0 " +
            "group by alcohol.id", nativeQuery = true)
    List<IOrderDetailDto> getCartList();

    @Query(value = "select sum(order_detail.quantity*alcohol.price) as totalBill, count(order_detail.id) as countAlcohol " +
            "from order_detail " +
            "join alcohol on order_detail.alcohol_id = alcohol.id " +
            "where order_detail.is_delete = 0 ", nativeQuery = true)
    ITotalDto getTotalBill();

    @Modifying
    @Query(value = "update order_detail set quantity = quantity + 1 " +
            "where order_detail.alcohol_id = :id and order_detail.is_delete = 0 ", nativeQuery = true)
    void updateCart(@Param("id") Integer id);

    @Modifying
    @Query(value = "insert into order_detail(alcohol_id, quantity, is_delete) values(:id, 1, 0) ", nativeQuery = true)
    void insertToCart(@Param("id") Integer id);

    @Query(value = "select * from order_detail where alcohol_id = :id ", nativeQuery = true)
    IOrderDetailDto findByIdAlcohol(@Param("id") Integer id);

    @Modifying
    @Query(value = "update order_detail set quantity = :quantity " +
            "where alcohol_id = :id and is_delete = 0 ", nativeQuery = true)
    void updateQuantity(Integer id, Integer quantity);

    @Modifying
    @Query(value = "update order_detail set is_delete = 1 " +
            "where id = :id", nativeQuery = true)
    void deleteAlcohol(Integer id);
}
