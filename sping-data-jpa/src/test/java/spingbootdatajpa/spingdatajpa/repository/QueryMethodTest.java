package spingbootdatajpa.spingdatajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spingbootdatajpa.spingdatajpa.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class QueryMethodTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByName() {
        Product product = productRepository.findByName("Product-2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
        System.out.println(product.getPrice());

    }

    @Test
    void findById() {
        Product product = productRepository.findById(20L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameAndDescription() {
        List<Product> product = productRepository.findByNameAndDescription("Product-2", "product 2 description");
        product.forEach(product1 -> {
            System.out.println(product1.getName());
            System.out.println(product1.getPrice());
        });



    }
    @Test
    void findDistinctByName(){
        Product product = productRepository.findDistinctByName("Product-2");
        System.out.println(product.getId());
        System.out.println(product.getName());

    }
    @Test
    void findByPriceGreaterThan(){
        List<Product> productList = productRepository.findByPriceGreaterThan(new BigDecimal(2000));
        productList.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });

    }
    @Test
    void findByPriceLessThan(){
        List<Product> product = productRepository.findByPriceLessThan(new BigDecimal(3000));
        product.forEach(product1 -> {
            System.out.println(product1.getId());
            System.out.println(product1.getName());
        });
    }
    @Test
    void findByNameContaining(){
        List<Product> productList = productRepository.findByNameContaining("Product-3");
        productList.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }
    @Test
    void findByNameLike(){
        List<Product> productList = productRepository.findByNameLike("Product-2");
        productList.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }
    @Test
    void findByPriceBetween(){
        List<Product> productList = productRepository.findByPriceBetween(new BigDecimal(1000),new BigDecimal(3000));
        productList.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
        });
    }
//    @Test
//    void findByCreateBetween(){
//        LocalDateTime startDate = LocalDateTime.of(2023,10,10,20,19,51);
//        LocalDateTime endDate = LocalDateTime.of(2023,10,10,21,19,19);
//        List<Product> productList = productRepository.findByCreateBetween(startDate,endDate);
//        productList.forEach(product -> {
//            System.out.println(product.getId());
//            System.out.println(product.getName());
//        });

    @Test
    void findByNameIn(){
        List<Product> productList = productRepository.findByNameIn(List.of("Product-3","Product-2","Product-4"));
        productList.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }
    @Test
    void findFirst2ByOrderByNameDesc(){
        List<Product> productList =productRepository.findFirst3ByOrderByNameDesc();
        productList.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }
}