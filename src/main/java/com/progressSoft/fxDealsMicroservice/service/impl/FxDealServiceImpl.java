package com.progressSoft.fxDealsMicroservice.service.impl;


import com.progressSoft.fxDealsMicroservice.dto.FxDealDTO;
import com.progressSoft.fxDealsMicroservice.error.ValidationException;
import com.progressSoft.fxDealsMicroservice.mapper.FxDealMapper;
import com.progressSoft.fxDealsMicroservice.model.FxDeal;
import com.progressSoft.fxDealsMicroservice.repo.FxDealRepository;
import com.progressSoft.fxDealsMicroservice.service.FxDealService;
import com.progressSoft.fxDealsMicroservice.service.FxDealValidationService;
import com.progressSoft.fxDealsMicroservice.validator.ValidationError;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FxDealServiceImpl implements FxDealService {
    private final FxDealRepository fxDealRepository;
    private FxDealMapper fxDealMapper;
    private final FxDealValidationService fxDealValidationService;

    public FxDealServiceImpl(FxDealRepository fxDealRepository, FxDealMapper fxDealMapper, FxDealValidationService fxDealValidationServiceImpl) {
        this.fxDealRepository = fxDealRepository;
        this.fxDealMapper = fxDealMapper;
        this.fxDealValidationService = fxDealValidationServiceImpl;
    }

    @Override
    public FxDealDTO saveDeal(FxDealDTO fxDealDTO) {
        List<ValidationError> validationErrors = fxDealValidationService.validateDeal(fxDealDTO);
        if (!CollectionUtils.isEmpty(validationErrors)) {
            throw new ValidationException("Error in saving deal", validationErrors);
        }

        FxDeal deal = fxDealMapper.toEntity(fxDealDTO);
        deal = fxDealRepository.save(deal);
        return fxDealMapper.toDto(deal);
    }

    public FxDealDTO getDealById(Long id) {
        List<ValidationError> validationErrors = fxDealValidationService.validateDealById(id);
        if (!CollectionUtils.isEmpty(validationErrors)) {
            throw new ValidationException("Error in retrieving deal", validationErrors);
        }
        Optional<FxDeal> optionalFxDeal = fxDealRepository.findById(id);
        if (optionalFxDeal.isPresent()) {
            FxDeal deal = optionalFxDeal.get();
            return fxDealMapper.toDto(deal);
        } else {
            throw new ValidationException("Deal not found", List.of());
        }
    }

    @Override
    public List<FxDealDTO> getAllDeals() {
        List<FxDeal> fxDeals = fxDealRepository.findAll();
        List<FxDealDTO> fxDealDTOS = new ArrayList<>();
        for (FxDeal fxDeal : fxDeals) {
            fxDealDTOS.add(fxDealMapper.toDto(fxDeal));
        }
        return fxDealDTOS;
    }
}
