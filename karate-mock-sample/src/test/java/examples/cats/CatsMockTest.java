package examples.cats;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.core.MockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
/**
 *
 * @author pthomas3
 */
class CatsMockTest {

    static MockServer server;

    @BeforeAll
    static void beforeAll() {
        server = MockServer
                .feature("classpath:examples/cats/cats-mock.feature")
                .http(33611).build();
    }

    @Test
    void testMock() {
        Results results = Runner.path("classpath:examples/cats/cats.feature")
                .karateEnv("mock")
                .systemProperty("mock.cats.url", "http://localhost:8089/cats")
                .parallel(1);
        assertTrue( results.getFailCount() == 0, results.getErrorMessages());
    }

    @AfterAll
    static void afterAll() {
        server.stop();
    }
    

}
