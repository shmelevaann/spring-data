package ru.chiffa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceBetween(int min, int max);

    List<Product> findAllByPriceGreaterThan(int min);

    List<Product> findAllByPriceLessThan(int max);

    Optional<Product> findById(Long id);

    void deleteById(Long id);
}
