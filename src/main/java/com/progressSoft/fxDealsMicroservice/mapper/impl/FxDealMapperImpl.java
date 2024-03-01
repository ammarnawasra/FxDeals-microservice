package com.progressSoft.fxDealsMicroservice.mapper.impl;

import com.progressSoft.fxDealsMicroservice.dto.FxDealDTO;
import com.progressSoft.fxDealsMicroservice.mapper.FxDealMapper;
import com.progressSoft.fxDealsMicroservice.model.FxDeal;
import org.springframework.stereotype.Component;


import java.util.Currency;

@Component
public class FxDealMapperImpl implements FxDealMapper {

    @Override
    public FxDealDTO toDto(FxDeal entity) {
        if ( entity == null ) {
            return null;
        }

        FxDealDTO fxDealDTO = new FxDealDTO();

        fxDealDTO.setId( entity.getId() );
        if ( entity.getFromCurrency() != null ) {
            fxDealDTO.setFromCurrency( entity.getFromCurrency().getCurrencyCode() );
        }
        if ( entity.getToCurrency() != null ) {
            fxDealDTO.setToCurrency( entity.getToCurrency().getCurrencyCode() );
        }
        fxDealDTO.setDealTimestamp( entity.getDealTimestamp() );
        fxDealDTO.setDealAmount( entity.getDealAmount() );

        return fxDealDTO;
    }

    @Override
    public FxDeal toEntity(FxDealDTO dto) {
        if ( dto == null ) {
            return null;
        }

        FxDeal fxDeal = new FxDeal();

        fxDeal.setId( dto.getId() );
        if ( dto.getFromCurrency() != null ) {
            fxDeal.setFromCurrency( Currency.getInstance( dto.getFromCurrency() ) );
        }
        if ( dto.getToCurrency() != null ) {
            fxDeal.setToCurrency( Currency.getInstance( dto.getToCurrency() ) );
        }
        fxDeal.setDealTimestamp( dto.getDealTimestamp() );
        fxDeal.setDealAmount( dto.getDealAmount() );

        return fxDeal;
    }
}
