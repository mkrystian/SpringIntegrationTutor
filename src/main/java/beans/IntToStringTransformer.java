package beans;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

@Component
public class IntToStringTransformer {

    @Transformer
    public String transform(int i) {
        return String.valueOf(i);
    }
}
