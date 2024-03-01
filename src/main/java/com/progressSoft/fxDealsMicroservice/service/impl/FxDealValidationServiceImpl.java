package com.progressSoft.fxDealsMicroservice.service.impl;

import com.progressSoft.fxDealsMicroservice.dto.FxDealDTO;
import com.progressSoft.fxDealsMicroservice.model.FxDeal;
import com.progressSoft.fxDealsMicroservice.repo.FxDealRepository;
import com.progressSoft.fxDealsMicroservice.service.FxDealValidationService;
import com.progressSoft.fxDealsMicroservice.validator.ValidationError;
import com.progressSoft.fxDealsMicroservice.validator.ValidationErrorBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class FxDealValidationServiceImpl implements FxDealValidationService {
    private final FxDealRepository fxDealRepository;

    public FxDealValidationServiceImpl(FxDealRepository fxDealRepository) {
        this.fxDealRepository = fxDealRepository;
    }

    public List<ValidationError> validateDeal(FxDealDTO fxDealDTO) {
        ValidationErrorBuilder validation = new ValidationErrorBuilder();
        if (fxDealDTO == null) {
            validation.addError("error.deal.null");
        } else {
            validateCurrency(fxDealDTO.getFromCurrency(), "from", validation);
            validateCurrency(fxDealDTO.getToCurrency(), "to", validation);
            validateDifferentCurrencies(fxDealDTO, validation);
            validateAmount(fxDealDTO.getDealAmount(), validation);
        }
        return validation.build();
    }

    private void validateCurrency(String currencyCode, String prefix, ValidationErrorBuilder validation) {
        if (!StringUtils.hasText(currencyCode) || !isISOCurrencyCodeValid(currencyCode)) {
            validation.addError("error.validation.currency." + prefix + ".not.valid", currencyCode);
        }
    }

    private boolean isISOCurrencyCodeValid(String currencyCode) {
        return Currency.getAvailableCurrencies().stream()
                .anyMatch(c -> c.getCurrencyCode().equals(currencyCode));
    }

    private void validateDifferentCurrencies(FxDealDTO fxDealDTO, ValidationErrorBuilder validation) {
        if (Objects.equals(fxDealDTO.getFromCurrency(), fxDealDTO.getToCurrency())) {
            validation.addError("error.validation.currency.name", fxDealDTO.getFromCurrency(), fxDealDTO.getToCurrency());
        }
    }

    private void validateAmount(BigDecimal amount, ValidationErrorBuilder validation) {
        if (amount == null) {
            validation.addError("error.validation.amount.not.valid");
        }
    }

    public List<ValidationError> validateDealById(Long id) {
        ValidationErrorBuilder validation = new ValidationErrorBuilder();
        Optional<FxDeal> optionalDeal = fxDealRepository.findById(id);
        if (optionalDeal.isEmpty()) {
            validation.addError("error.validation.deal.not.exist", id);
        }
        return validation.build();
    }
}