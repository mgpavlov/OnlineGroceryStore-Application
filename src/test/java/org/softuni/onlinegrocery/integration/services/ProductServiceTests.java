package org.softuni.onlinegrocery.integration.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.softuni.onlinegrocery.domain.entities.Product;
import org.softuni.onlinegrocery.domain.models.service.CategoryServiceModel;
import org.softuni.onlinegrocery.domain.models.service.ProductServiceModel;
import org.softuni.onlinegrocery.repository.ProductRepository;
import org.softuni.onlinegrocery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTests {
    @Autowired
    private ProductService service;

    @MockBean
    private ProductRepository mockProductRepository;


    @Test(expected = NullPointerException.class)
    public void createProduct_whenValid_productCreated() throws IOException {
        ProductServiceModel product = new ProductServiceModel();
        MultipartFile multipartFile = new MultipartFile() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getOriginalFilename() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public void transferTo(File file) throws IOException, IllegalStateException {

            }
        };
        product.setCategories(List.of(new CategoryServiceModel()));
        when(mockProductRepository.save(any()))
                .thenReturn(new Product());

        when(mockProductRepository.save(any()))
                .thenReturn(new MultipartFile() {
                    @Override
                    public String getName() {
                        return null;
                    }

                    @Override
                    public String getOriginalFilename() {
                        return null;
                    }

                    @Override
                    public String getContentType() {
                        return null;
                    }

                    @Override
                    public boolean isEmpty() {
                        return false;
                    }

                    @Override
                    public long getSize() {
                        return 0;
                    }

                    @Override
                    public byte[] getBytes() throws IOException {
                        return new byte[0];
                    }

                    @Override
                    public InputStream getInputStream() throws IOException {
                        return null;
                    }

                    @Override
                    public void transferTo(File file) throws IOException, IllegalStateException {

                    }
                });

        service.createProduct(product, null);
        verify(mockProductRepository)
              .save(any());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createProduct_whenNull_throw() throws IOException {
        service.createProduct(null, null);
        verify(mockProductRepository)
                .save(any());
    }
}
