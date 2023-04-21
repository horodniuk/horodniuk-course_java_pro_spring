package org.example.store.service;

import lombok.RequiredArgsConstructor;
import org.example.store.dto.ProductDto;
import org.example.store.entity.Product;
import org.example.store.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductDto addProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product tempProduct = productRepository.save(product);
        return modelMapper.map(tempProduct, ProductDto.class);
    }

    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        return modelMapper.map(product, ProductDto.class);
    }

    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products.stream()
                .map(product -> getMappingProduct(product))
                .collect(Collectors.toList());
    }

    private ProductDto getMappingProduct(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

}
