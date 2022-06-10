package com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

import static lombok.AccessLevel.PACKAGE;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = PACKAGE)
@ToString
public class ProductDto {
    private Long id;
    private String name;
    private String index;
    private String description;
    private BigDecimal price;
    private Long shopId;

    public ProductDto(String name, String description, BigDecimal price, Long shopId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.shopId = shopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductDto that = (ProductDto) o;

        return new EqualsBuilder().append(name, that.name).append(price, that.price).append(shopId, that.shopId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).append(price).append(shopId).toHashCode();
    }
}
