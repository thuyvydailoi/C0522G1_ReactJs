package com.codegym.service.alcohol;

import com.codegym.model.alcohol.AlcoholType;

import java.util.List;

public interface IAlcoholTypeService {
    List<AlcoholType> findAll();
}
