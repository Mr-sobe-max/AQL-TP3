package EXO3;

import org.example.com.EXO3.ApiException;
import org.example.com.EXO3.Product;
import org.example.com.EXO3.ProductApiClient;
import org.example.com.EXO3.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/* EXO 03 + LES TESTS */
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductApiClient productApiClient;

    @Test
    void testGetProductSuccess() throws ApiException {
        // Arrange
        String productId = "123";
        Product expectedProduct = new Product(productId, "Smartphone", 599.99);
        when(productApiClient.getProduct(productId)).thenReturn(expectedProduct);
        ProductService productService = new ProductService(productApiClient);

        // Act
        Product result = productService.getProduct(productId);

        // Assert
        assertEquals(expectedProduct, result);
        verify(productApiClient).getProduct(productId);
        verifyNoMoreInteractions(productApiClient);
    }

    @Test
    void testGetProductInvalidFormat() throws ApiException {
        // Arrange
        String productId = "invalid";
        when(productApiClient.getProduct(productId)).thenThrow(new ApiException("Format de données incompatible"));
        ProductService productService = new ProductService(productApiClient);

        // Act & Assert
        ApiException exception = assertThrows(ApiException.class, () -> productService.getProduct(productId));
        assertEquals("Format de données incompatible", exception.getMessage());
        verify(productApiClient).getProduct(productId);
        verifyNoMoreInteractions(productApiClient);
    }

    @Test
    void testGetProductApiFailure() throws ApiException {
        // Arrange
        String productId = "123";
        when(productApiClient.getProduct(productId)).thenThrow(new ApiException("Échec de l'appel API"));
        ProductService productService = new ProductService(productApiClient);

        // Act & Assert
        ApiException exception = assertThrows(ApiException.class, () -> productService.getProduct(productId));
        assertEquals("Échec de l'appel API", exception.getMessage());
        verify(productApiClient).getProduct(productId);
        verifyNoMoreInteractions(productApiClient);
    }
}
