package EXO1;

/* EXO 01 + LES TESTS */
import org.example.com.EXO1.User;
import org.example.com.EXO1.UserRepository;
import org.example.com.EXO1.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Test
    void testGetUserById() {
        // Arrange
        long userId = 1L;
        User expectedUser = new User(userId, "Jean Dupont");
        when(userRepository.findUserById(userId)).thenReturn(expectedUser);
        UserService userService = new UserService(userRepository);

        // Act
        User result = userService.getUserById(userId);

        // Assert
        assertEquals(expectedUser, result);
        verify(userRepository).findUserById(userId);
        verifyNoMoreInteractions(userRepository);
    }
}
