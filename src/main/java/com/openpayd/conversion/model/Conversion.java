package com.openpayd.conversion.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "conversion")
public class Conversion {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="conversion_amount")
    private BigDecimal conversionAmount;

    public Conversion(Long id, BigDecimal conversionAmount) {
        this.id = id;
        this.conversionAmount = conversionAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getConversionAmount() {
        return conversionAmount;
    }

    public void setConversionAmount(BigDecimal conversionAmount) {
        this.conversionAmount = conversionAmount;
    }
}
