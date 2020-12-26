package ru.chiffa;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @GetMapping
    public List<Product> findAllProducts(@RequestParam (required = false) Integer min,
                                         @RequestParam (required = false) Integer max) {
        if (min == null & max == null) {
            return productRepository.findAll();
        } else if (min == null) {
            return productRepository.findAllByPriceLessThan(max);
        } else if (max == null) {
            return productRepository.findAllByPriceGreaterThan(min);
        }
        return productRepository.findAllByPriceBetween(min, max);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
