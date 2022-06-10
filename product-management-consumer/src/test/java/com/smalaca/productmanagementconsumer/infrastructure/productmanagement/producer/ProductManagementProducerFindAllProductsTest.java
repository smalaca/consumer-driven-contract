package com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureStubRunner(
        ids = {"com.smalaca:product-management:+:stubs:8200"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ProductManagementProducerFindAllProductsTest {
    @Autowired
    private ProductManagementProducer producer;

    @Test
    void shouldReturnProductsForGivenShop() {
        List<ProductDto> actual = producer.findAllForShopId(13L);

        assertThat(actual)
                .hasSize(3)
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new ProductDto(1L, "Water", "ABC123", "Something to drink", BigDecimal.valueOf(123.45), 13L)))
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new ProductDto(2L, "Tea", "XYZ987", "Good for breakfast", BigDecimal.valueOf(13.42), 13L)))
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new ProductDto(3L, "Coffee", "A1B2C3", "The best drink ever", BigDecimal.valueOf(321.12), 13L)));
    }

    @Test
    void shouldReturnNoProductForNotExistingShop() {
        List<ProductDto> actual = producer.findAllForShopId(7L);

        assertThat(actual).isEmpty();
    }
}