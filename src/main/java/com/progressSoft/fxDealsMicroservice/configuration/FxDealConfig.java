package com.progressSoft.fxDealsMicroservice.configuration;


import com.progressSoft.fxDealsMicroservice.repo.FxDealRepository;
import com.progressSoft.fxDealsMicroservice.service.FxDealValidationService;
import com.progressSoft.fxDealsMicroservice.service.impl.FxDealValidationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FxDealConfig {

    @Bean
    public FxDealValidationService dealValidator(FxDealRepository fxDealRepository) {
        return new FxDealValidationServiceImpl(fxDealRepository);
    }
}
