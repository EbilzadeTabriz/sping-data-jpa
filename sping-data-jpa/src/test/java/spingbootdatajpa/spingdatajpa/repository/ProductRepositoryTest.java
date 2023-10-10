package spingbootdatajpa.spingdatajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spingbootdatajpa.spingdatajpa.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create product
        Product product = new Product();
        product.setName("Product-4");
        product.setDescription("product 4 description");
        product.setSku("400ABC");
        product.setPrice(new BigDecimal(4000));
        product.setActive(true);
        product.setImageUrl("product.png");
        //save
        Product saveProduct = productRepository.save(product);
        //display
        System.out.println(saveProduct.getId());
        System.out.println(saveProduct.toString());

    }
    @Test
    void updateUsingSaveMethod(){
        //find or retrieve an entity by id
        Long id = 12L;
        Product product = productRepository.findById(id).get();

        //update
        product.setName("Update-Product-1");
        product.setDescription("Update-product 1 description");

        //save updated entity
        productRepository.save(product);

    }
    @Test
    void findById(){
        //find
        Long id = 20L;

        Product product = productRepository.findById(id).get();
        //


    }
    @Test
    void saveAllMethod(){
        //create product
        Product product = new Product();
        product.setName("Product-2");
        product.setDescription("product 2 description");
        product.setSku("200ABC");
        product.setPrice(new BigDecimal(2000));
        product.setActive(true);
        product.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("Product-3");
        product3.setDescription("product 3 description");
        product3.setSku("300ABC");
        product3.setPrice(new BigDecimal(3000));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product,product3));
    }
    @Test
    void findAllMethod(){
        List<Product> productList = productRepository.findAll();
        productList.forEach((p)->{
            System.out.println(p.getName());
        });
    }
    @Test
    void deleteById(){
        Long id =12L;
        productRepository.deleteById(id);

    }
    @Test
    void delete(){
        //find on entity by id
        Long id = 22L;
        Product product = productRepository.findById(id).get();
        //delete entity
        productRepository.delete(product);

        //delete(entity)
    }
    @Test
    void deleteAll(){
        Product product = productRepository.findById(18L).get();
        Product product1 = productRepository.findById(19L).get();
        productRepository.deleteAll(List.of(product1,product));
    }
    @Test
    void existsById(){
        Long id = 20L;
        Boolean result = productRepository.existsById(id);
    }
    @Test
    void count(){
        Long count = productRepository.count();
        System.out.println(count);
    }
    @Test
    void existsByIdMethod(){
        Long id = 20L;
        Boolean result = productRepository.existsById(id);
        System.out.println(result);
    }
}