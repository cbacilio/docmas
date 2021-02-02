import org.junit.Assert;
import org.junit.Test;

import com.javainuse.components.SpringBootHelloWorldService;

public class HelloWorldTest {

    private SpringBootHelloWorldService springBootHelloWorldService = new SpringBootHelloWorldService();

    @Test
    public void itShouldSayHolaMundo() {
        Assert.assertEquals("Hola Mundo cbm", springBootHelloWorldService.helloWorld());
    }

}