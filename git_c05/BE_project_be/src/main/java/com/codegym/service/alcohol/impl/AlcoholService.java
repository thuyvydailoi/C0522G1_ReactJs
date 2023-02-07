package com.codegym.service.alcohol.impl;

import com.codegym.dto.IAlcoholDto;
import com.codegym.model.alcohol.Alcohol;
import com.codegym.repository.alcohol.IAlcoholRepository;
import com.codegym.service.alcohol.IAlcoholService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlcoholService implements IAlcoholService {
    @Autowired
    private IAlcoholRepository iAlcoholRepository;

    @Override
    public Page<IAlcoholDto> findAllAlcoholAndSearch(String nameSearch, Pageable pageable) {
        return iAlcoholRepository.findAllAlcoholAndSearch(nameSearch, pageable);
    }

    @Override
    public Page<IAlcoholDto> findAllAlcoholByTypeAndSearch(String nameSearch, Pageable pageable, int type) {
        return iAlcoholRepository.findAllAndAlcoholByTypeAndSearch(nameSearch, type, pageable);
    }

    @Override
    public void saveAlcohol(Alcohol alcohol) {
        iAlcoholRepository.saveAlcohol(alcohol);
    }

    @Override
    public void editAlcohol(Alcohol alcohol) {
        iAlcoholRepository.editAlcohol(alcohol);
    }


    @Override
    public Optional<IAlcoholDto> findByIdAlcohol(Integer id) {
        return iAlcoholRepository.findByIdAlcohol(id);
    }
}
