package com.codegym.repository.alcohol;

import com.codegym.dto.IAlcoholDto;
import com.codegym.model.alcohol.Alcohol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IAlcoholRepository extends JpaRepository<Alcohol, Integer> {
    @Query(value = "select id, name, is_delete, price, discount, description, manufacturer, image, alcohol_type_id" +
            " from alcohol " +
            "where name like %:nameSearch% and is_delete = 0 ",
            countQuery = "select count(*) from alcohol  " +
                    "where name like %:nameSearch% and is_delete = 0 ",
            nativeQuery = true)
    Page<IAlcoholDto> findAllAlcoholAndSearch(@Param("nameSearch") String nameSearch, Pageable pageable);

    @Query(value = "select id, name, is_delete, price, discount,description, manufacturer, image, alcohol_type_id" +
            " from alcohol " +
            "where name like %:nameSearch% and alcohol_type_id = :type and is_delete = 0 ",
            countQuery = "select count(*) from alcohol  " +
                    "where name like %:nameSearch% and alcohol_type_id = :type and is_delete = 0 ",
            nativeQuery = true)
    Page<IAlcoholDto> findAllAndAlcoholByTypeAndSearch(@Param("nameSearch") String nameSearch,
                                                       @Param("type") int type,
                                                       Pageable pageable);

    @Modifying
    @Query(value = "insert into Alcohol(name ,price, discount, description, manufacturer, image, is_delete) " +
            "VALUES (:#{#alcohol.name} , :#{#alcohol.price}, :#{#alcohol.discount}, :#{#alcohol.description}, :#{#alcohol.manufacturer}, :#{#alcohol.image}, 0 )", nativeQuery = true)
    void saveAlcohol(@Param("alcohol") Alcohol alcohol);

    @Modifying
    @Query(value = "update Alcohol set name =:#{#alcohol.name},price =:#{#alcohol.price},discount =:#{#alcohol.discount},description =:#{#alcohol.description},manufacturer =:#{#alcohol.manufacturer},image =:#{#alcohol.image} " +
            "where id =:#{#alcohol.id}", nativeQuery = true)
    void editAlcohol(@Param("alcohol") Alcohol alcohol);

//    @Query(value = "select id, name, is_delete, price, discount, manufacturer, image, alcohol_type_id" +
//            " from alcohol " +
//            "where name like %:nameSearch% and alcohol_type_id = 2 and is_delete = 0 ",
//            countQuery = "select count(*) from alcohol  " +
//                    "where name like %:nameSearch% and is_delete = 0 ",
//            nativeQuery = true)
//    Page<IAlcoholDto> findAllBaseAndSearch(@Param("nameSearch") String nameSearch, Pageable pageable);

//    @Query(value = "select id, name, is_delete, price, discount, manufacturer, image, alcohol_type_id" +
//            " from alcohol " +
//            "where name like %:nameSearch% and alcohol_type_id = 3 and is_delete = 0 ",
//            countQuery = "select count(*) from alcohol  " +
//                    "where name like %:nameSearch% and is_delete = 0 ",
//            nativeQuery = true)
//    Page<IAlcoholDto> findAllWineAndSearch(@Param("nameSearch") String nameSearch, Pageable pageable);

    @Query(value = "select id as id, name as name, is_delete as is_delete, price as price, discount as discount, description as description, manufacturer as manufacturer, image as image, alcohol_type_id " +
            " from alcohol  where id = :id and is_delete = 0 ", nativeQuery = true)
    Optional<IAlcoholDto> findByIdAlcohol(@Param("id") Integer id);

}
