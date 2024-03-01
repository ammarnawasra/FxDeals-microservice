package com.progressSoft.fxDealsMicroservice.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class FxDealTest {

    @Test
    void testConstructor() {
        // Arrange
        FxDeal actualDeal = new FxDeal();
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);

        // Act
        actualDeal.setDealAmount(valueOfResult);
        actualDeal.setFromCurrency(null);
        actualDeal.setId(1L);
        actualDeal.setToCurrency(null);

        // Assert
        assertSame(valueOfResult, actualDeal.getDealAmount());
        assertNull(actualDeal.getFromCurrency());
        assertNull(actualDeal.getToCurrency());
    }
}