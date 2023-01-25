package si.um.feri.measurements.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import si.um.feri.measurements.dto.Product;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productRest;

    Product newProduct=null;

    @Test
    void getProductById() {
        Product fromServer=productRest.getProductById(newProduct.id()).getBody();
        assertEquals(newProduct.id(),fromServer.id());
    }

    @BeforeEach
    void postProduct() {
        newProduct = productRest.postProduct(
                new Product(0, "Product", 22.0, -23.5)
        ).getBody();
    }

    @Test
    void deleteProduct() {
        String res  = productRest.deleteProduct(newProduct.id()).getBody();
        assertEquals("deleted", res);
    }
}