package com.codegym.controller;

import com.codegym.dto.IAlcoholDto;
import com.codegym.model.alcohol.Alcohol;
import com.codegym.model.alcohol.AlcoholType;
import com.codegym.service.alcohol.IAlcoholService;
import com.codegym.service.alcohol.IAlcoholTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/alcohol")
public class AlcoholRestController {
    @Autowired
    private IAlcoholService iAlcoholService;

    @Autowired
    private IAlcoholTypeService iAlcoholTypeService;

    @GetMapping("/list")
    public ResponseEntity<Page<IAlcoholDto>> findAllAlcoholAndSearch(
            @PageableDefault(value = 8) Pageable pageable,
            @RequestParam(value = "nameSearch", defaultValue = "", required = false) String nameSearch) {
        Page<IAlcoholDto> alcoholDtoPage = iAlcoholService.findAllAlcoholAndSearch(nameSearch, pageable);
        if (alcoholDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alcoholDtoPage, HttpStatus.OK);
    }

    @GetMapping("/alcoholByTypeList")
    public ResponseEntity<Page<IAlcoholDto>> findAllSpiritsAndSearch(
            @PageableDefault(value = 8) Pageable pageable,
            @RequestParam(value = "nameSearch", defaultValue = "", required = false) String nameSearch,
    @RequestParam(value = "type", defaultValue = "", required = false) int type) {
        Page<IAlcoholDto> alcoholDtoPage = iAlcoholService.findAllAlcoholByTypeAndSearch(nameSearch, pageable, type);
        if (alcoholDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alcoholDtoPage, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveAlcohol(@RequestBody @Valid Alcohol alcohol, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        iAlcoholService.saveAlcohol(alcohol);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> editAlcohol(@RequestBody @Valid Alcohol alcohol, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        iAlcoholService.editAlcohol(alcohol);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findByIdAlcohol(@PathVariable Integer id) {
        Optional<IAlcoholDto> alcoholDtoOptional = iAlcoholService.findByIdAlcohol(id);
        if (alcoholDtoOptional.isPresent()) {
            return new ResponseEntity<>(alcoholDtoOptional, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    //    @GetMapping("/baseList")
//    public ResponseEntity<Page<IAlcoholDto>> findAllBaseAndSearch(
//            @PageableDefault(value = 8) Pageable pageable,
//            @RequestParam(value = "nameSearch", defaultValue = "", required = false) String nameSearch) {
//        Page<IAlcoholDto> alcoholDtoPage = iAlcoholService.findAllBaseAndSearch(nameSearch, pageable);
//        if (alcoholDtoPage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(alcoholDtoPage, HttpStatus.OK);
//    }

//    @GetMapping("/wineList")
//    public ResponseEntity<Page<IAlcoholDto>> findAllWineAndSearch(
//            @PageableDefault(value = 8) Pageable pageable,
//            @RequestParam(value = "nameSearch", defaultValue = "", required = false) String nameSearch) {
//        Page<IAlcoholDto> alcoholDtoPage = iAlcoholService.findAllWineAndSearch(nameSearch, pageable);
//        if (alcoholDtoPage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(alcoholDtoPage, HttpStatus.OK);
//    }

    @GetMapping("/type-list")
    public ResponseEntity<List<AlcoholType>> findAllAlcoholType() {
        List<AlcoholType> alcoholTypes = iAlcoholTypeService.findAll();
        if (alcoholTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alcoholTypes, HttpStatus.OK);
    }



}
