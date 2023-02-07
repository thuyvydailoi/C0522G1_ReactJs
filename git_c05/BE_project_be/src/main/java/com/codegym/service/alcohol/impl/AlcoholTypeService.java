package com.codegym.service.alcohol.impl;

import com.codegym.model.alcohol.AlcoholType;
import com.codegym.repository.alcohol.IAlcoholTypeRepository;
import com.codegym.service.alcohol.IAlcoholTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlcoholTypeService implements IAlcoholTypeService {

    private IAlcoholTypeRepository iAlcoholTypeRepository;
    @Override
    public List<AlcoholType> findAll() {
        return iAlcoholTypeRepository.findAll();
    }
}
