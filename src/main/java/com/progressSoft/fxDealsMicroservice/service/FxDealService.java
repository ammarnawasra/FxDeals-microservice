package com.progressSoft.fxDealsMicroservice.service;



import com.progressSoft.fxDealsMicroservice.dto.FxDealDTO;


import java.util.List;


public interface FxDealService {
    FxDealDTO saveDeal(FxDealDTO fxDealDTO);

    FxDealDTO getDealById(Long id);

    List<FxDealDTO> getAllDeals();
}
