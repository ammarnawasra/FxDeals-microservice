package com.progressSoft.fxDealsMicroservice.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;

@Entity
@Table(name = "fx_deal")
public class FxDeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "From currency should not be null")
    @Column(name = "from_currency", nullable = false)
    private Currency fromCurrency;

    @NotNull(message = "To currency should not be null")
    @Column(name = "to_currency", nullable = false)
    private Currency toCurrency;

    @CreationTimestamp
    @Column(name = "deal_timestamp", nullable = false, updatable = false)
    private Instant dealTimestamp;

    @Column(name = "deal_amount")
    private BigDecimal dealAmount;


    // Constructor
    public FxDeal() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
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

    // Equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FxDeal fxDeal = (FxDeal) o;
        return id.equals(fxDeal.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}