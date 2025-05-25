package EXO2;

import org.example.com.EXO2.Order;
import org.example.com.EXO2.OrderController;
import org.example.com.EXO2.OrderDao;
import org.example.com.EXO2.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
    @Mock
    private OrderService orderService;

    @Mock
    private OrderDao orderDao;

    @InjectMocks
    private OrderController orderController;

    @Test
    void testCreateOrder() {
        // Arrange
        Order order = new Order(1L, "Laptop", 999.99);
        OrderService realOrderService = new OrderService(orderDao);
        orderController = new OrderController(realOrderService);

        // Act
        orderController.createOrder(order);

        // Assert
        verify(orderDao).saveOrder(order);
    }
}