package com.progressSoft.fxDealsMicroservice.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class FxDealDTOTest {

    @Test
    void testConstructor() {
        // Arrange
        FxDealDTO actualFxDealDTO = new FxDealDTO();
        BigDecimal value = BigDecimal.valueOf(42L);

        // Act
        actualFxDealDTO.setDealAmount(value);
        actualFxDealDTO.setFromCurrency("USD");
        actualFxDealDTO.setToCurrency("USD");
        actualFxDealDTO.setId(30L);

        // Assert
        assertSame(value, actualFxDealDTO.getDealAmount());
        assertNotEquals("JOD", actualFxDealDTO.getFromCurrency());
        assertNotEquals("JOD", actualFxDealDTO.getToCurrency());
        assertNotEquals(15L, actualFxDealDTO.getId());
    }
}