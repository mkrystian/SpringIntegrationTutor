package beans;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SoutBean {

    @ServiceActivator
    public Message<String> sout(Integer randomValue,
                                @Header int headerName,
                                @Headers Map<String, Object> headers) {
        System.out.println(randomValue);
        return MessageBuilder.withPayload(randomValue.toString())
                .copyHeaders(headers)
                .setHeader("anotherHeader", headerName - 2)
                .build();
    }
}
