package org.example.store.service;

import lombok.RequiredArgsConstructor;
import org.example.store.dto.ProductDto;
import org.example.store.entity.Product;
import org.example.store.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServive{
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    @Override
    public Product addOrUpdate(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return productRepository.save(product);
    }




    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }
}
