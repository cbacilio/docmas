import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.javainuse.components.SpringBootHelloWorldService;
import com.javainuse.controllers.SpringBootHelloWorldController;

public class HolaMundoControllerUnitTest {

    private SpringBootHelloWorldController springBootHelloWorldController;
    private SpringBootHelloWorldService springBootHelloWorldService;

    @Before
    public void setUp() {
    	springBootHelloWorldService = Mockito.mock(SpringBootHelloWorldService.class);
    	springBootHelloWorldController = new SpringBootHelloWorldController(springBootHelloWorldService);
    }

    @Test
    public void itShouldReturnTheServiceValueWith200StatusCode() {
        Mockito.when(springBootHelloWorldService.helloWorld()).thenReturn("Saludos");
        ResponseEntity<String> httpResponse = springBootHelloWorldController.sayHello();

        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals("Saludos", httpResponse.getBody());
    }

}