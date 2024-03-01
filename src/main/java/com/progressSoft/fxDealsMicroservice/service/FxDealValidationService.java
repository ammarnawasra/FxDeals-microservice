package com.progressSoft.fxDealsMicroservice.service;

import com.progressSoft.fxDealsMicroservice.dto.FxDealDTO;
import com.progressSoft.fxDealsMicroservice.validator.ValidationError;


import java.util.List;

public interface FxDealValidationService {
    List<ValidationError> validateDeal(FxDealDTO fxDealDTO);

    List<ValidationError> validateDealById(Long id);
}