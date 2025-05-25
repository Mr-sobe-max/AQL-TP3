package org.example.com.EXO3;

public interface ProductApiClient {
    Product getProduct(String productId) throws ApiException;
}
