package com.progressSoft.fxDealsMicroservice.mapper;

import com.progressSoft.fxDealsMicroservice.dto.FxDealDTO;
import com.progressSoft.fxDealsMicroservice.model.FxDeal;


public interface FxDealMapper {
    FxDealDTO toDto(FxDeal entity);
    FxDeal toEntity(FxDealDTO dto);

}