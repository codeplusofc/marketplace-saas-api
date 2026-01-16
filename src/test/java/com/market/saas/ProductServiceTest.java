package com.market.saas;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import com.market.saas.model.ProductEntity;
import com.market.saas.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes de API - ProductService")
public class ProductServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("Deve retornar BadRequest quando o nome do produto estiver faltando")
    public void shouldReturnBadRequestWhenProductNameIsMissing() throws Exception {

        String invalidProductJson = """
                {
                    "orderId": 1,
                    "productPrice": 10.0,
                    "quantity": 5
                }
                """;


        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidProductJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve retornar Created quando o produto for válido")
    public void shouldReturnCreatedWhenProductIsValid() throws Exception {

        String validProductJson = """
                {
                    "orderId": 1,
                    "productId": 101,
                    "productName": "Notebook",
                    "productPrice": 3500.0,
                    "quantity": 1
                }
                """;


        ProductEntity mockProduct = new ProductEntity(1L, 101L, "Notebook", 3500.0, 1);
        when(productRepository.save(any(ProductEntity.class))).thenReturn(mockProduct);


        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validProductJson))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Deve retornar BadRequest quando o preço for negativo")
    public void shouldReturnBadRequestWhenPriceIsNegative() throws Exception {

        String invalidPriceJson = """
                {
                    "productName": "Teclado",
                    "productPrice": -50.0,
                    "quantity": 1
                }
                """;


        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidPriceJson))
                .andExpect(status().isBadRequest());
    }
}