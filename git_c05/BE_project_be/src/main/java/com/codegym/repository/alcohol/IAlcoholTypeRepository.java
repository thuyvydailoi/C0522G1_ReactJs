package com.codegym.repository.alcohol;

import com.codegym.model.alcohol.AlcoholType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAlcoholTypeRepository extends JpaRepository<AlcoholType, Integer> {
    @Query(value = "select id, name, is_delete" +
            " from alcohol_type  where is_delete = 0", nativeQuery = true)
    List<AlcoholType> findAllAlcoholType();
}
