package pl.jkanclerz.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jkanclerz.ecommerce.catalog.ArrayListProductStorage;
import pl.jkanclerz.ecommerce.catalog.ProductCatalog;

import java.util.ArrayList;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyCatalog() {
        var catalog = new ProductCatalog(new ArrayListProductStorage());
        catalog.addProduct("Lego set 8083", "Nice one");
        catalog.addProduct("Cobi blocks", "Nice one");

        return catalog;
    }
}
