package spingbootdatajpa.spingdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spingbootdatajpa.spingdatajpa.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName(String name);

    List<Product> findByNameAndDescription(String name,
                                           String description);

    Optional<Product> findById(Long id);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

//    List<Product> findByCreateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Product> findByNameIn(List<String> names);
    List<Product> findFirst3ByOrderByNameDesc();


}

