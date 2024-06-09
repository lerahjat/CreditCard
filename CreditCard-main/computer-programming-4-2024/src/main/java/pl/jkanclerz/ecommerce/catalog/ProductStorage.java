package pl.jkanclerz.ecommerce.catalog;

import java.util.List;

public interface ProductStorage {
    List<Product> allProducts();

    void add(Product newProduct);

    Product getProductBy(String id);
}
