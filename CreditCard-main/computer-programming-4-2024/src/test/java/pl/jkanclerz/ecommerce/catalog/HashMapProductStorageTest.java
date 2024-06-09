package pl.jkanclerz.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class HashMapProductStorageTest {


    private static final String EXAMPLE_PRODUCT_NAME = "Lego 8083";

    @Test
    void itStoresProducts() {
        ProductStorage productStorage = thereIsProductStorage();
        Product product = thereisExampleProduct();

        productStorage.add(product);
        List<Product> products = productStorage.allProducts();

        assertThat(products)
                .hasSize(1)
                .extracting(Product::getName)
                .contains(EXAMPLE_PRODUCT_NAME);
    }

    private Product thereisExampleProduct() {
        var product = new Product(UUID.randomUUID(), EXAMPLE_PRODUCT_NAME, "Obdachloss");
        return product;
    }

    private ProductStorage thereIsProductStorage() {
        return new HashMapProductStorage();
    }
}
