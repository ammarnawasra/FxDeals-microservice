package com.progressSoft.fxDealsMicroservice.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class FxDealDTO {
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private Instant dealTimestamp;
    private BigDecimal dealAmount;

    // Constructors
    public FxDealDTO() {
    }

    public FxDealDTO(Long id, String fromCurrency, String toCurrency, Instant dealTimestamp, BigDecimal dealAmount) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.dealTimestamp = dealTimestamp;
        this.dealAmount = dealAmount;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Instant getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(Instant dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }

    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }
}