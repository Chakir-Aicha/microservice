package com.microservice.productservice.tests;

import com.microservice.productservice.domain.model.Product;
import com.microservice.productservice.dto.ProductResponse;
import com.microservice.productservice.repository.ProductRepository;
import com.microservice.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    //Mock
        @Mock
        private ProductRepository productRepository;

        @InjectMocks
        private ProductService productService;

        @Test
        public void shouldReturnAllProducts() {
            // given
            List<Product> productList = new ArrayList<>();

            // when
            when(productRepository.findAll()).thenReturn(productList);

            // action
            List<ProductResponse> result = productService.getAllProducts(); // assuming productService calls productRepository.findAll()

            // assert
            assertEquals(productList.size(), result.size());
        }
}
