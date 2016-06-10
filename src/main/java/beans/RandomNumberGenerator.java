package beans;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberGenerator {

    @ServiceActivator
    public int randomInt(String aa) {
        return new Random().nextInt();
    }

    @ServiceActivator
    public int randomInt(int i) {
        return 42;
    }

    // ...
}

