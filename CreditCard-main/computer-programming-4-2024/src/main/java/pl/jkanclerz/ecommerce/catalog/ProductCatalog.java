package pl.jkanclerz.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {


    private final ProductStorage products;

    public ProductCatalog(ProductStorage products) {
        this.products = products;
    }

    public List<Product> allProducts() {
        return products.allProducts();
    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id, name, description);

        products.add(newProduct);

        return newProduct.getId();
    }

    public Product getProductBy(String id) {
        return products.getProductBy(id);
    }

    public void changePrice(String id, BigDecimal newPrice) {
        Product loaded = this.getProductBy(id);
        loaded.changePrice(newPrice);
    }
}
