package com.progressSoft.fxDealsMicroservice.controller;

import com.progressSoft.fxDealsMicroservice.annotation.ResponseWrapper;
import com.progressSoft.fxDealsMicroservice.dto.FxDealDTO;
import com.progressSoft.fxDealsMicroservice.service.FxDealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@ResponseWrapper
@RestController
@RequestMapping("/fxDeal")
public class FxDealController {

    private final FxDealService fxDealService;

    public FxDealController(FxDealService fxDealService) {
        this.fxDealService = fxDealService;
    }

    @PostMapping("/create")
    public ResponseEntity<FxDealDTO> createDeal(@Valid @RequestBody FxDealDTO fxDealDTO) throws URISyntaxException {
        FxDealDTO savedDeal = fxDealService.saveDeal(fxDealDTO);
        return ResponseEntity
                .created(new URI("/fxDeal/" + savedDeal.getId()))
                .body(savedDeal);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FxDealDTO> retrieveDealById(@PathVariable("id") Long id) {
        FxDealDTO fxDealDTO = fxDealService.getDealById(id);
        return ResponseEntity.ok(fxDealDTO);
    }

    @GetMapping("/deals")
    public ResponseEntity<List<FxDealDTO>> retrieveAllDeals() {
        List<FxDealDTO> allDeals = fxDealService.getAllDeals();
        return ResponseEntity.ok(allDeals);
    }

    // Exception handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
    }
}