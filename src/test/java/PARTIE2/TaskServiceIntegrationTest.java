package PARTIE2;

/* LES TESTS D'INTEGRATION */
import org.example.com.PARTIE2.Task;
import org.example.com.PARTIE2.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.MySQLContainer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
public class TaskServiceIntegrationTest {

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("tp3db")
            .withUsername("user")
            .withPassword("pass");

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }

    @Autowired
    private TaskService taskService;

    @Test
    public void testCreateTask() {
        Task task = new Task("Tache 1", "Description");
        taskService.saveTask(task);

        Optional<Task> result = taskService.findTaskById(task.getId());
        assertTrue(result.isPresent());
        assertEquals("Tache 1", result.get().getTitle());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("A supprimer", "A tester");
        taskService.saveTask(task);
        Long id = task.getId();
        taskService.deleteTaskById(id);
        assertFalse(taskService.findTaskById(id).isPresent());
    }
}
